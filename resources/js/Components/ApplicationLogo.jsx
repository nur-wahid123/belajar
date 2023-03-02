
import axios from 'axios';
import { useState } from 'react';
import './logo.css'

export default function ApplicationLogo({ className }) {
  const [data, setData] = useState();
  async function fetchDataAsync() {
    const result = await axios.get("/logo");
    setData(result.data.value);
  }
  setTimeout(() => {
    fetchDataAsync();
  }, 500);
  const imageUrl = '/asetkubro/' + data;
  const head = document.head
  const link = head.querySelector('link[rel="shortcut icon"]')
  link.setAttribute('href',imageUrl)

  return (
    data == undefined ? (
      <div className="lds-ellipsis"><div></div><div></div><div></div><div></div></div>
    ) : (
      <div>
        <img src={imageUrl} className={className} alt="LOGO SMA" />
      </div>
    )
  )
}