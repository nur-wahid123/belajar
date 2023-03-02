const today = new Date();
const year = today.getFullYear();
const month = (today.getMonth() + 1).toString().padStart(2, '0'); // add leading zero if month is single digit
const day = today.getDate().toString().padStart(2, '0'); // add leading zero if day is single digit
const date = `${year}-${month}-${day}`;

export default date