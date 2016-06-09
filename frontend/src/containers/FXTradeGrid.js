import React from 'react';
import FXItem from './FXItem';

const FXTradeGrid = () => {
  const items = [
    { id: 1 },
    { id: 2 },
    { id: 3 },
  ];
  const fxItems = items.map((item) => <FXItem key={item.id} />);
  return (
    <div className="trade-grid">
    {fxItems}
    </div>
  );
};

export default FXTradeGrid;
