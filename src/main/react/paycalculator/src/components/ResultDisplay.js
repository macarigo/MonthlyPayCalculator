import React from 'react';

function ResultDisplay({ totalPay }) {
    return (
        <div>
            <h2>Total payment due: {totalPay} €</h2>
        </div>
    );
}

export default ResultDisplay;