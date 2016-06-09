import React from 'react';
import PriceTicker from '../containers/PriceTicker';

const GridItem = () => {
  return (
    <div className="grid-item">
      <div>
        <h5>gbp|usd</h5>
      </div>
      <PriceTicker />
      <div>
        <button />
        <button />
      </div>
    </div>
  );
};

export default GridItem;
