populateBookingTable();

async function getAllBookings()
{
    const url = "http://localhost:8080/findAllBookingsForAllUsers";
    return await fetch(url).then(x => x.json());
}

async function populateBookingTable()
{
    const bookingTable = document.getElementById("bookingTable")
    const bookingsList = await getAllBookings();
    const timeslotValues = ["08:00-10:00","10:00-12:00","12:00-14:00","14:00-16:00"]

    bookingsList.forEach(booking =>
    {
        bookingTable.innerHTML += "<tr>";
        bookingTable.innerHTML +=
            `
                <td>${booking.bookingDate}</td>
                <td>${timeslotValues[booking.timeslotId - 1]}</td>
                <td>${booking.title}</td>
                <td>${booking.equipment}</td>
                <td>${booking.minAge}</td>
                <td>${booking.minHeight}</td>
                <td>${booking.userFirstName} ${booking.userLastname}</td>
                <td>${booking.userBirthDate}</td>
                <td>${booking.height}</td>
            `
        bookingTable.innerHTML += "</tr>";
    })
}

