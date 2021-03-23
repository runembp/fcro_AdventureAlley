const dropdownMyBookings = document.querySelector("#dropdownMyBooking");
const useremail = document.getElementById("useremail");

const email = window.location.pathname.substring(19);

const userUrl = `http://localhost:8080/bookings/${email}`;

useremail.innerHTML += email;

getBookingToUser();

async function getBookingToUser(){

    const response = await fetch(userUrl);
    const bookings = await response.json();


    for(let i = 0; i < bookings.length; i++)
{
    let bookingId = bookings[i].bookingId;

    //Bruges til at hente aktivitet til den pågælgende booking
    const activityUrl = `http://localhost:8080/getActivityToBooking/${bookingId}`;
    const response1 = await fetch(activityUrl)
    const activity = await response1.json();

    //Bruges til at hente timeslot for booking
    const timeslotUrl = `http://localhost:8080/timeslotForBooking/${bookingId}`;
    const repsonse2 = await fetch(timeslotUrl);
    const timeslot = await  repsonse2.json();

    let element = document.createElement("p");
    element.innerText = activity.title + ' ' + bookings[i].bookingDate + ' '+ timeslot.start + ' ' + timeslot.end;

    dropdownMyBookings.appendChild(element);
    };

}







