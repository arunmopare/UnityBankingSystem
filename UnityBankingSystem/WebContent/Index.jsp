<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Unity Bank</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="Style.css">
    <link rel="stylesheet" href="MobileStyle.css">
    <script src="https://kit.fontawesome.com/e12d480ba5.js" crossorigin="anonymous"></script>

</head>
<body>

    <header>
        <div class="container-fluid">
            <nav class="navbar navbar-expand-lg">
                <a class="navbar-brand" href="#">Unity</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                    aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <div class="mr-auto"></div>
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Apply Now</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Net Banking</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Pages
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#"></a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About Us</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="container text-center">
            <div class="row">
                <div class="col-md-7 col-sm-12 ">
                    <h6>UNITY BANK</h6>
                    <h1>THE ULTIMATE BANK</h1>
                    <p>
                        We are one of leading banks of India and our goal is to provide the Reliable and fastest Online
                        banking System to our customers.
                    </p>
                    <button class="btn btn-light px-5 py-2">
                        Create Your Free Account Now
                    </button>
                </div>
                <div class="col-md-5 col-sm-12 ">
                    <img src="Assets/pigfinal.png" alt="">
                </div>
            </div>
        </div>
    </header>

    <main>
        <section class="section-1">
            <div class="container text-center">
                <div class="row">
                    <div class="col-md-6">
                        <div class="pray">
                            <img src="../assets/12.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel text-left">
                            <h1>Mr David Smith</h1>
                            <p class="pt-4">
                                This is a paragraph
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="section-2  container-fluid p-0">
            <div class="cover">
                <div class="content text-center">
                    <h1>Some Features That Made Us Unique</h1>
                    <p>
                        This is a sample 2 Paragraaph
                    </p>
                </div>
            </div>
            <div class="container-fluid text-center">
                <div class="numbers d-flex flex-md-row flex-wrap justify-content-center">
                    <div class="rect">
                        <h1>2345</h1>
                        <p>Happy Customers</p>
                    </div>
                    <div class="rect">
                        <h1>50</h1>
                        <p>Branches</p>
                    </div>
                    <div class="rect">
                        <h1>5000</h1>
                        <p>Transactions</p>
                    </div>
                    <div class="rect">
                        <h1>40</h1>
                        <p>Partner Banks</p>
                    </div>
                </div>
            </div>
            <div class="platform row">
                <div class="col-md-6 col-sm-12 text-right">
                    <div class="desktop shadow-lg">
                        <div class="d-flex flex-row justify-content-center">
                            <i class="fas fa-desktop fa-3x py-2 pr-3"></i>
                            <div class="text text-left">
                                <h3 class="pt-1 m-0">Desktop</h3>
                                <p class="p-0 m-0">On website</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-sm-12 text-left">
                    <div class="desktop shadow-lg">
                        <div class="d-flex flex-row justify-content-center">
                            <i class="fas fa-mobile-alt fa-3x py-2 pr-3"></i>
                            <div class="text text-left">
                                <h3 class="pt-1 m-0">On Mobile</h3>
                                <p class="p-0 m-0">On Play Store</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </main>

    <footer>

        <div class="container-fluid p-0">
            <div class="row text-left">
                <div class="col-md-5 col-sm-5">
                    <h4 class="text-light">About us</h4>
                    <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Earum maxime ea
                        similique illum corrupti</p>
                    <p class="pt-4 text-muted">Copyright ©2019 All rights reserved
                        <span> Daily Banking</span>
                    </p>
                </div>
                <div class="col-md-5 col-sm-12">
                    <h4 class="text-light">Newsletter</h4>
                    <p class="text-muted">Stay Updated</p>
                    <form class="form-inline">
                        <div class="col pl-0">
                            <div class="input-group pr-5">
                                <input type="text" class="form-control bg-dark text-white"
                                    id="inlineFormInputGroupUsername2" placeholder="Email">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="fas fa-arrow-right"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-2 col-sm-12">
                    <h4 class="text-light">Follow Us</h4>
                    <p class="text-muted">Let us be social</p>
                    <div class="column text-light">
                        <i class="fab fa-facebook-f"></i>
                        <i class="fab fa-instagram"></i>
                        <i class="fab fa-twitter"></i>
                        <i class="fab fa-youtube"></i>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    </script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous">
    </script>
    <script src="Main.js"></script>
</body>
</html>