import React, { useState, useEffect } from "react";
import fetch from "./api";
import "./styles.css";

function calculateResults(incomingData) {
  // Calculate points per transaction
  const months = [
    "Jan",
    "Feb",
    "Mar",
    "Apr",
    "May",
    "Jun",
    "Jul",
    "Aug",
    "Sep",
    "Oct",
    "Nov",
    "Dec",
  ];
  const pointsPerTransaction = incomingData.map((transaction) => {
    let points = 0;
    let over100 = transaction.amt - 100;

    if (over100 > 0) {
      points += over100 * 2;
    }
    if (transaction.amt > 50) {
      points += 50;
    }
    const month = new Date(transaction.transactionDt).getMonth();
    return { ...transaction, points, month };
  });

  let byCustomer = {};
  let totalPointsByCustomer = {};
  pointsPerTransaction.forEach((pointsPerTransaction) => {
    let { custid, name, month, points } = pointsPerTransaction;
    if (!byCustomer[custid]) {
      byCustomer[custid] = [];
    }
    if (!totalPointsByCustomer[custid]) {
      totalPointsByCustomer[name] = 0;
    }
    totalPointsByCustomer[name] += points;
    if (byCustomer[custid][month]) {
      byCustomer[custid][month].points += points;
      byCustomer[custid][month].monthNumber = month;
      byCustomer[custid][month].numTransactions++;
    } else {
      byCustomer[custid][month] = {
        custid,
        name,
        monthNumber: month,
        month: months[month],
        numTransactions: 1,
        points,
      };
    }
  });
  let tot = [];
  for (var custKey in byCustomer) {
    byCustomer[custKey].forEach((cRow) => {
      tot.push(cRow);
    });
  }

  let totByCustomer = [];
  for (custKey in totalPointsByCustomer) {
    totByCustomer.push({
      name: custKey,
      points: totalPointsByCustomer[custKey],
    });
  }
  return {
    summaryByCustomer: tot,
    pointsPerTransaction,
    totalPointsByCustomer: totByCustomer,
  };
}

function App() {
  const [transactionData, setTransactionData] = useState(null);

  useEffect(() => {
    fetch().then((data) => {
      const results = calculateResults(data);
      setTransactionData(results);
    });
  }, []);

  if (transactionData == null) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <div className="container">
        <h2>Points Rewards System Totals by Customer Months</h2>
        <table>
          <thead>
            <tr>
              <th>Customer</th>
              <th>Month</th>
              <th># of Transactions</th>
              <th>Reward Points</th>
            </tr>
          </thead>
          <tbody>
            {transactionData.summaryByCustomer.map((row, index) => (
              <React.Fragment key={index}>
                <tr>
                  <td>{row.name}</td>
                  <td>{row.month}</td>
                  <td>{row.numTransactions}</td>
                  <td>{row.points}</td>
                </tr>
                <tr>
                  <td colSpan="4">
                    <div>
                      {transactionData.pointsPerTransaction
                        .filter(
                          (tRow) =>
                            row.custid === tRow.custid &&
                            row.monthNumber === tRow.month
                        )
                        .map((tran, idx) => (
                          <div key={idx}>
                            <strong>Transaction Date:</strong>{" "}
                            {tran.transactionDt} - <strong>$</strong>
                            {tran.amt} - <strong>Points: </strong>
                            {tran.points}
                          </div>
                        ))}
                    </div>
                  </td>
                </tr>
              </React.Fragment>
            ))}
          </tbody>
        </table>
      </div>

      <div className="container">
        <h2>Points Rewards System Totals By Customer</h2>
        <table>
          <thead>
            <tr>
              <th>Customer</th>
              <th>Points</th>
            </tr>
          </thead>
          <tbody>
            {transactionData.totalPointsByCustomer.map((row, index) => (
              <tr key={index}>
                <td>{row.name}</td>
                <td>{row.points}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default App;
