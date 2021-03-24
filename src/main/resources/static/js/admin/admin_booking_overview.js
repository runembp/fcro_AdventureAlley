const bookingsContainer = document.getElementById("bookingContainer");

async function getAllBookings()
{
    const url = "http://localhost:8080/findAllBookingsForUsers";
    return await fetch(url).then(x => x.json());
}

let bookingList = getAllBookings().then(x =>
{
    bookingList = x;
    console.log(x);
});

bookingList.forEach(x =>
{

})

