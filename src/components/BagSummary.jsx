import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";

function BagSummary() {
  const [order, setOrder] = useState({
    totalItem: 0,
    totalMRP: 0,
    totalDiscount: 0,
    finalPayment: 0,
  });

  const CONVIENCE_FEES = 99;
  const bagItems = useSelector((state) => state.bag);
  const items = useSelector((state) => state.items);
  const finalItems = items.filter((item) => {
    return bagItems.indexOf(item.id) >= 0;
  });

  useEffect(() => {
    let totalItem = 0;
    let totalMRP = 0;
    let totalDiscount = 0;
    finalItems.forEach((item) => {
      totalItem += 1;
      totalMRP += item.current_price;
      totalDiscount += item.discount_percentage;
    });
    setOrder({
      totalItem,
      totalMRP,
      totalDiscount,
      finalPayment: totalMRP - totalDiscount + CONVIENCE_FEES,
    });
  }, [bagItems, items]);

  return (
    <div className="bag-summary">
      <div className="bag-details-container">
        <div className="price-header">
          PRICE DETAILS ({order.totalItem} Items){" "}
        </div>
        <div className="price-item">
          <span className="price-item-tag">Total MRP</span>
          <span className="price-item-value">₹{order.totalMRP}</span>
        </div>
        <div className="price-item">
          <span className="price-item-tag">Discount on MRP</span>
          <span className="price-item-value priceDetail-base-discount">
            -₹{order.totalDiscount}
          </span>
        </div>
        <div className="price-item">
          <span className="price-item-tag">Convenience Fee</span>
          <span className="price-item-value">₹{CONVIENCE_FEES}</span>
        </div>
        <hr />
        <div className="price-footer">
          <span className="price-item-tag">Total Amount</span>
          <span className="price-item-value">₹{order.finalPayment}</span>
        </div>
      </div>
      <button className="btn-place-order">
        <div className="css-xjhrni">PLACE ORDER</div>
      </button>
    </div>
  );
}

export default BagSummary;
