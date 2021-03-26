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
    const row = bookingTable.insertRow();
    const timeslotValues = ["08:00-10:00","10:00-12:00","12:00-14:00","14:00-16:00"]

    console.log(bookingsList)

    console.log(bookingsList[1])

    console.log(bookingsList.length)

    for(const booking of bookingsList)
    {
        const bookingDate = row.insertCell(0)
        bookingDate.innerText = booking.bookingDate;

        const timeslotId = row.insertCell(1)
        timeslotId.innerText = timeslotValues[booking.timeslotId - 1];

        const title = row.insertCell(2)
        title.innerText = booking.title;

        const equipment = row.insertCell(3)
        equipment.innerText = booking.equipment;

        const minAge = row.insertCell(4)
        minAge.innerText = booking.minAge;

        const minHeight = row.insertCell(5)
        minHeight.innerText = booking.minHeight;

        const userName = row.insertCell(6)
        userName.innerText = booking.userFirstName + " " + booking.userLastname;

        const height = row.insertCell(7)
        height.innerText = booking.height;
    }
}

