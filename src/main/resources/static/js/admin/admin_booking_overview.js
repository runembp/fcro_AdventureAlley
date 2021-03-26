const bookingTable = document.getElementById("bookingTable")

async function getAllBookings()
{
    const url = "http://localhost:8080/findAllBookingsForAllUsers";
    return await fetch(url).then(x => x.json());
}

function populateBookingTable(bookingList)
{
    const row = bookingTable.insertRow;

}
const title = row.insertCell(0);
title.innerHTML = "Booking title";

const date = row.insertCell(1);
date.innerHTML = "Booking date";