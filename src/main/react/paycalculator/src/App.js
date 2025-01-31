import React, { useState } from 'react';
import './App.css';
import InputFields from './components/InputFields';
import ResultDisplay from './components/ResultDisplay';
import axios from 'axios';

function App() {
    const [totalPay, setTotalPay] = useState(0);
    const [isLoading, setIsLoading] = useState(false);
    const [error, setError] = useState (null);

    const handleSubmit = async (payPeriod) => {
        setIsLoading(true);
        setError(null);

    try {
        const response = await axios.post('/api/pay', payPeriod);
        setTotalPay(response.data.totalPay);
    } catch (error) {
        console.error("Error:", error);
        setError("An error occured while calculating payment.");
    } finally {
        setIsLoading(false);
    }
};


return (
    <div className="App">
      <h1>Payment Calculator</h1>
      <InputFields onInputChange={handleSubmit} />
      <button onClick={handleSubmit} disabled={isLoading}>
        {isLoading ? 'Calculating...' : 'Calculate'}
      </button>
      {error && <p className="error">{error}</p>}
      <ResultDisplay totalPay={totalPay} />
    </div>
  );
}

export default App;
