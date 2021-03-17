


window.onload = function createOverview() {
    const container = document.createElement('div');
    container.setAttribute('class', 'container-fluid bg-dark');
    document.body.appendChild(container);

    const row = document.createElement('div');
    row.setAttribute('class', 'row');
    container.appendChild(row);

    const col_left = document.createElement('div');
    col_left.setAttribute('class', 'col');
    row.appendChild(col_left);

    const h1 = document.createElement('h1');
    h1.setAttribute('class', 'text-danger' + ' ms-5');
    h1.textContent = "GoKart";
    col_left.appendChild(h1);

    const p = document.createElement('p');
    p.setAttribute('class', 'text-danger ms-5')
    p.textContent = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.";
    col_left.appendChild(p);

    const p_price = document.createElement('p');
    p_price.setAttribute('class', 'text-danger ms-5');
    p_price.textContent = "Price: x";
    col_left.appendChild(p_price);

    const p_height = document.createElement('p');
    p_height.setAttribute('class', 'text-danger ms-5');
    p_height.textContent = "MinHeight: x";
    col_left.appendChild(p_height);

    const col_right = document.createElement('div');
    col_right.setAttribute('class', 'col text-center');
    row.appendChild(col_right);

    const img = document.createElement('img');
    img.setAttribute('class', 'h-100 w-50 p-4');
    img.setAttribute('src', 'https://images.pexels.com/photos/861464/pexels-photo-861464.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260');
    col_right.appendChild(img);
}