const dropdownMyBookings = document.getElementById("dropdownMyBooking");

let email = window.location.pathname.substring(19);

const userUrl = `http://localhost:8080/findUserByEmail/${email}`;

console.log(userUrl);

document.getElementById("email1").innerHTML = email;

let list

function getBookingsForCurrentUser(){

}








