<?php
session_start();

if (isset($_SESSION['id']) && isset($_SESSION['user_name'])) {

?>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="viewport" content="width=device-width , initial-scale=1">
        <link rel="stylesheet" href="parts.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Chivo+Mono&family=Inter&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/0469953560.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Storage</title>
    </head>

    <body>

        <header class="header">

            <a href="home.php" class="logo"> <img src="image\partpicker.png"></a>

            <nav class="navbar">
                <a href="home.php">home</a>
                <a href="builder.php">builder</a>
                <div class="dropdown">
                    <button class="dropbtn"><a>Browse Products <i class="fa-solid fa-caret-down"></i></button></a>
                    <div class="dropdown-content">
                        <table>
                            <tr>
                                <td>
                                    <div class="gallery">
                                        <a target="_blank" href="cpu.php">
                                            <img src="image/nav-cpu.png" width="100" height="100">
                                        </a>
                                        <div class="desc">CPU</div>
                                    </div>
                                <td>
                                    <div class="gallery">
                                        <a target="_blank" href="memory.php">
                                            <img src="image/nav-memory.png" width="100" height="100">
                                        </a>
                                        <div class="desc">Memory</div>
                                    </div>
                                <td>
                                    <div class="gallery">
                                        <a target="_blank" href="cpucooler.php">
                                            <img src="image/nav-cpucooler.png" width="100" height="100">
                                        </a>
                                        <div class="desc">CPU Cooler</div>
                                    </div>
                                <td>
                                    <div class="gallery">
                                        <a target="_blank" href="motherboard.php">
                                            <img src="image/nav-motherboard.png" width="100" height="100">
                                        </a>
                                        <div class="desc">Motherboard</div>
                                    </div>
                                <td>

                            <tr>
                                <td>
                                    <div class="gallery">
                                        <a target="_blank" href="storage.php">
                                            <img src="image/nav-ssd.png" width="100" height="100">
                                        </a>
                                        <div class="desc">Storage</div>
                                    </div>
                                <td>

                                    <div class="gallery">
                                        <a target="_blank" href="videocard.php">
                                            <img src="image/nav-videocard.png" width="100" height="100">
                                        </a>
                                        <div class="desc">Graphics Card</div>
                                    </div>
                                </td>
                                <td>
                                    <div class="gallery">
                                        <a target="_blank" href="powersupply.php">
                                            <img src="image/nav-powersupply.png" width="100" height="100">
                                        </a>
                                        <div class="desc">Power Supply</div>
                                    </div>
                                </td>
                                <td>
                                    <div class="gallery">
                                        <a target="_blank" href="case.php">
                                            <img src="image/nav-case.png" width="100" height="100">
                                        </a>
                                        <div class="desc">Cabinet</div>
                                    </div>
                                </td>
                        </table>
                    </div>
                </div>

                <a href="Compare.php">Compare</a>
            </nav>

            <div class="login-status">

                <a href="profile.html">

                    <i class="fa-solid fa-user"> <?php echo "<styles>" . $_SESSION['user_name'];
                                                    "</styles>" ?></i>
                </a>
            </div>

            <div class="icons">
                <div class="fas fa-bars" id="menu-btn"></div>
                <div class="fas fa-search" id="search-btn"></div>
                <div class="fas fa-shopping-cart" id="cart-btn"></div>
                <a href="logout.php">
                    <div class="fa-solid fa-arrow-right-from-bracket" id="logout-btn"></div>
                </a>
            </div>
            <form action="" class="search-form">
                <input type="search" id="search-box" placeholder="search here...">
                <label for="search-box" class="fas fa-search"></label>
            </form>
        </header>
        <section class="parts">
            <div class="content">
                <h3>Choose Storage</h3>
            </div>
        </section>
        <section class="products">
            <center>
                <table class="table table-light table-striped table-bordered">
                    <thead class="thead-dark">
                        <tr>
                            <th>Product</th>
                            <th>Price</th>
                            <th>Selection</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr id="Product">
                            <td class="product"></td>
                            <td class="selection"></td>
                            <td class="source"></td>
                        </tr>
                        <tr id="Product">
                            <td class="product"></td>
                            <td class="selection"></td>
                            <td class="source"></td>
                        </tr>
                        <tr id="Product">
                            <td class="product"></td>
                            <td class="selection"></td>
                            <td class="source"></td>
                        </tr>
                        <tr id="Product">
                            <td class="product"></td>
                            <td class="selection"></td>
                            <td class="source"></td>
                        </tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        </tr>
                    </tbody>
                </table>
            </center>
        </section>
        <section class="footer" id="footer">
            <table>
                <tr>
                    <td>
                        <div class="f1">
                            <img src="image/logo.png">
                            <br>
                            <p>
                                PICK PARTS.<br>
                                BUILD YOUR PC.<br>
                                COMPARE AND SHARE.
                            </p>
                        </div>
                    </td>
                    <td>
                        <div class="f2">
                            <center>
                                <h1>Catergories</h1>
                                <center>
                                    <hr>
                                    <br>
                                    <center>
                                        <p>
                                            <a href="Builder.php">Builder</a><br>
                                            <a href="browse.php">Browse Products</a><br>
                                            <a href="Compare.php">Compare</a>
                                        </p>
                                    </center>
                        </div>
                    </td>
                    <td>
                        <div class="f2">
                            <center>
                                <h1>Company</h1>
                                <center>
                                    <hr>
                                    <br>
                                    <center>
                                        <p>
                                        <a href="about.php">About</a><br>
                                        <a href="ucc.php">User Code Of Conduct</a>
                                        </p>
                                    </center>
                        </div>
                    </td>
                </tr>
            </table>
        </section>
        <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
        <!-- custom js file link  -->
        <script src="script.js"></script>
    </body>
<?php
} else {
    header("Location: login.php");
    exit();
}
?>

    </html>