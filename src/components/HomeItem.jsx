import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { bagAction } from "../store/bagSlice";
import { IoIosAddCircle } from "react-icons/io";
import { IoIosRemoveCircle } from "react-icons/io";
function HomeItem({ item }) {
  const dispatch = useDispatch();
  const bagItems = useSelector((store) => store.bag);
  const elementFound = bagItems.indexOf(item.id) >= 0;
  console.log("Element found" + elementFound);
  const handleAddToBag = () => {
    dispatch(bagAction.addToBag(item.id));
  };
  const handleRemoveFromBag=()=>{
    dispatch(bagAction.removeFromBag(item.id))
  }
  return (
    <div className="item-container">
      <img className="item-image" src={item.image} alt="item image" />
      <div className="rating">
        {item.rating.stars} ⭐ {item.rating.count}
      </div>
      <div className="company-name">{item.company}</div>
      <div className="item-name">{item.item_name}</div>
      <div className="price">
        <span className="current-price">Rs {item.current_price}</span>
        <span className="original-price">Rs {item.original_price}</span>
        <span className="discount">({item.discount_percentage}% OFF)</span>
      </div>
      {elementFound ? (
        <button
          type="button"
          onClick={handleRemoveFromBag}
          className="btn btn-danger"
          style={{ minWidth: "100%" ,marginBottom: "4%", marginTop: "4%", }}
        >
          <IoIosRemoveCircle /> Remove from Bag
        </button>
      ) : (
        <button
          type="button"
          onClick={handleAddToBag}
          className="btn btn-primary"
          style={{ marginBottom: "4%", marginTop: "4%", minWidth: "100%" }}
        >
          <IoIosAddCircle /> Add to Bag
        </button>
      )}
    </div>
  );
}

export default HomeItem;
