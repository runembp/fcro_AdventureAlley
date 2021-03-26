const bookingTable = document.getElementById("bookingTable")

async function getAllBookings()
{
    const url = "http://localhost:8080/findAllBookingsForAllUsers";
    return await fetch(url).then(x => x.json());
}

async function populateBookingTable()
{
    const bookingsList = await getAllBookings();
    const row = bookingTable.insertRow();
    console.log(bookingsList);

    bookingsList.forEach((booking, index) =>
    {
        console.log(index)

        booking.forEach(property =>
        {
            // property
        })
    })

    const title = row.insertCell(0);
    const date = row.insertCell(1);
    date.innerHTML = "Booking date";
}

populateBookingTable();