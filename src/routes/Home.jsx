import React from 'react'
import HomeItem from '../components/HomeItem';
import { useSelector } from 'react-redux';

function Home() {
 const items= useSelector((store)=>store.items)

  return (
   <main>
   <div className="items-container">
      {items.map((item,index)=>
      <HomeItem item={item} key={index}  />
      )}
     
   </div>
 </main>
  )
}

export default Home