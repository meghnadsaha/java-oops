### Create Web Design using Bootstrap
<img src="https://img.freepik.com/premium-vector/website-layout-web-pages-template-internet-browser-window-with-banners-ui-elements-icons-vector_80590-6784.jpg?w=2000"/>

To create a layout similar to the one in your image using Bootstrap, you can use the following code. This layout includes a carousel at the top and three content cards below it.

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Bootstrap Layout</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- Carousel -->
<div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <div class="d-block w-100" style="height: 300px; background-color: #ccc;"></div>
    </div>
    <div class="carousel-item">
      <div class="d-block w-100" style="height: 300px; background-color: #aaa;"></div>
    </div>
    <div class="carousel-item">
      <div class="d-block w-100" style="height: 300px; background-color: #888;"></div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<!-- Card Section -->
<div class="container my-5">
  <div class="row">
    <div class="col-md-4">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">Card 1</h5>
          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">Card 2</h5>
          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">Card 3</h5>
          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```

### Explanation:
- **Carousel**: This is created using Bootstrap's carousel component. Each `.carousel-item` has a placeholder with a background color.
- **Cards**: A row of three cards is added below the carousel. Each card has a title and a paragraph to simulate the content.

This layout should match the structure in your image. Let me know if you need further customization!

### Full code react bootstrap with grid:

Here’s how you can create this layout in a React app using React Bootstrap. This code includes a carousel at the top and a responsive grid with three cards below it.

1. First, make sure to install `react-bootstrap` and `bootstrap` in your project:

   ```bash
   npm install react-bootstrap bootstrap
   ```

2. In your `index.js` or `App.js`, import the Bootstrap CSS:

   ```javascript
   import 'bootstrap/dist/css/bootstrap.min.css';
   ```

3. Here’s the complete code for the layout in a React component:

   ```javascript
   import React from 'react';
   import { Carousel, Container, Row, Col, Card } from 'react-bootstrap';

   function App() {
     return (
       <div>
         {/* Carousel Section */}
         <Carousel>
           <Carousel.Item>
             <div style={{ height: '300px', backgroundColor: '#ccc' }} className="d-flex justify-content-center align-items-center">
               <h3>Slide 1</h3>
             </div>
           </Carousel.Item>
           <Carousel.Item>
             <div style={{ height: '300px', backgroundColor: '#aaa' }} className="d-flex justify-content-center align-items-center">
               <h3>Slide 2</h3>
             </div>
           </Carousel.Item>
           <Carousel.Item>
             <div style={{ height: '300px', backgroundColor: '#888' }} className="d-flex justify-content-center align-items-center">
               <h3>Slide 3</h3>
             </div>
           </Carousel.Item>
         </Carousel>

         {/* Cards Section */}
         <Container className="my-5">
           <Row>
             <Col md={4}>
               <Card>
                 <Card.Body>
                   <Card.Title>Card 1</Card.Title>
                   <Card.Text>
                     Some quick example text to build on the card title and make up the bulk of the card's content.
                   </Card.Text>
                 </Card.Body>
               </Card>
             </Col>
             <Col md={4}>
               <Card>
                 <Card.Body>
                   <Card.Title>Card 2</Card.Title>
                   <Card.Text>
                     Some quick example text to build on the card title and make up the bulk of the card's content.
                   </Card.Text>
                 </Card.Body>
               </Card>
             </Col>
             <Col md={4}>
               <Card>
                 <Card.Body>
                   <Card.Title>Card 3</Card.Title>
                   <Card.Text>
                     Some quick example text to build on the card title and make up the bulk of the card's content.
                   </Card.Text>
                 </Card.Body>
               </Card>
             </Col>
           </Row>
         </Container>
       </div>
     );
   }

   export default App;
   ```

### Explanation of the Code

- **Carousel**: The `Carousel` component contains three `Carousel.Item`s, each with a placeholder for slide content. You can replace the placeholder text and background colors with images or other content as needed.
- **Grid with Cards**: The `Container` houses a `Row` with three `Col` elements, each containing a `Card` component. The `md={4}` prop on each `Col` ensures that the cards take up one-third of the row on medium screens and above, making the layout responsive.

### Additional Notes

- The carousel height is set to 300px using inline styles, but you can customize it as needed.
- The grid layout will adjust to different screen sizes thanks to Bootstrap's responsive `Col` component.

This code should give you a responsive layout similar to your design. Let me know if you need any further customization!

### full code bootstrap and react bootstrap with grid: Second Image

Here’s how to create a layout similar to the one in your image using React Bootstrap, featuring a central video player section, a sidebar, and a grid layout below.

1. First, make sure you have `react-bootstrap` and `bootstrap` installed:

   ```bash
   npm install react-bootstrap bootstrap
   ```

2. Import the Bootstrap CSS in your `index.js` or `App.js`:

   ```javascript
   import 'bootstrap/dist/css/bootstrap.min.css';
   ```

3. Here’s the complete code for the layout in a React component:

   ```javascript
   import React from 'react';
   import { Container, Row, Col, Card } from 'react-bootstrap';

   function App() {
     return (
       <Container fluid>
         {/* Top Navigation Bar */}
         <Row className="bg-dark text-white py-2">
           <Col>
             <h5 className="text-center">Top Navigation Bar</h5>
           </Col>
         </Row>

         {/* Main Content Area */}
         <Row className="mt-3">
           {/* Video Section */}
           <Col md={8}>
             <Card className="mb-3">
               <div style={{ height: '300px', backgroundColor: '#ccc', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                 <span>Video Player</span>
               </div>
             </Card>

             {/* Horizontal Grid Section */}
             <Row className="text-center">
               <Col md={4}>
                 <Card className="mb-2">
                   <Card.Body>Section 1</Card.Body>
                 </Card>
               </Col>
               <Col md={4}>
                 <Card className="mb-2">
                   <Card.Body>Section 2</Card.Body>
                 </Card>
               </Col>
               <Col md={4}>
                 <Card className="mb-2">
                   <Card.Body>Section 3</Card.Body>
                 </Card>
               </Col>
             </Row>

             {/* Content Below the Grid */}
             <Card className="mt-3">
               <Card.Body>
                 <p>
                   Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.
                 </p>
                 <p>
                   Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                 </p>
                 <p>
                   Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                 </p>
               </Card.Body>
             </Card>
           </Col>

           {/* Sidebar */}
           <Col md={4}>
             <Card className="mb-3">
               <div style={{ height: '300px', backgroundColor: '#aaa', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                 <span>Sidebar Content</span>
               </div>
             </Card>

             {/* Additional Content or Widgets */}
             <Row>
               <Col xs={6}>
                 <Card className="mb-2">
                   <Card.Body>Widget 1</Card.Body>
                 </Card>
               </Col>
               <Col xs={6}>
                 <Card className="mb-2">
                   <Card.Body>Widget 2</Card.Body>
                 </Card>
               </Col>
             </Row>
           </Col>
         </Row>
       </Container>
     );
   }

   export default App;
   ```

### Explanation

- **Top Navigation Bar**: A simple row at the top to represent the navigation bar.
- **Main Content Area**: The main content is split into two columns:
    - **Left Column (Main Video Section)**:
        - The top section is a card with a placeholder for a video player.
        - Below the video player, there’s a row of three cards arranged horizontally, representing three sections.
        - At the bottom, there’s a larger card for additional text or content.
    - **Right Column (Sidebar)**:
        - The top section is a placeholder for sidebar content.
        - Below the sidebar, there are two smaller widgets in a grid layout.

This layout is fully responsive and will adjust according to screen size. Let me know if you need further customization!

### Design Two:

<img src="https://img.freepik.com/premium-vector/website-landing-structure-footer-header-page-template-with-contact-blog-news-videos-options-scheme-websites-wireframe-vector-design-illustration-interface-website-structure_80590-20750.jpg?w=826"/>

Here’s the full code for a landing page with a navigation bar, hero banner, information cards, company advantages, a cases carousel, a contact form, and a footer. This layout is implemented in both **React Bootstrap** and **plain HTML with Bootstrap** for maximum flexibility. Each section is styled to resemble the layout in your provided image.

---

### React Bootstrap Code (App.js + App.css)

1. **Install Dependencies**:
   Make sure you have `react-bootstrap` and `bootstrap` installed:

   ```bash
   npm install react-bootstrap bootstrap
   ```

2. **App.js** - Main Component Code

   ```javascript
   import React from 'react';
   import { Container, Row, Col, Navbar, Nav, Button, Card, Carousel, Form } from 'react-bootstrap';
   import './App.css';

   function App() {
     return (
       <Container fluid>
         {/* Navbar */}
         <Navbar expand="lg" className="navbar-light bg-white border-bottom">
           <Container>
             <Navbar.Brand href="#">COMPANY</Navbar.Brand>
             <Nav className="ms-auto">
               <Nav.Link href="#">Company</Nav.Link>
               <Nav.Link href="#">Our Cases</Nav.Link>
               <Nav.Link href="#">Blog</Nav.Link>
               <Nav.Link href="#" className="text-primary">News</Nav.Link>
               <Nav.Link href="#">Contact</Nav.Link>
               <Nav.Link href="#" className="ms-4 text-dark fw-bold">999-456-009</Nav.Link>
             </Nav>
           </Container>
         </Navbar>

         {/* Hero Section */}
         <Container className="hero-section my-5">
           <Row>
             <Col md={6}>
               <h1>Landing Page Template</h1>
               <h4 className="text-muted">Loreipsum Title</h4>
               <p className="text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
               <Button variant="primary">Next</Button>
             </Col

Here’s the complete plain HTML code for the landing page layout using Bootstrap. This layout includes sections for navigation, a hero banner, information cards, company advantages, a cases carousel, a contact form, and a footer.

---

### Full HTML and CSS Code

1. Add Bootstrap’s CSS and JavaScript in the `<head>` and before the closing `</body>` tag.

   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Landing Page Template</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
     <style>
       body {
         background-color: #e9f2f8;
       }
       .hero-section h1 {
         font-size: 2.5rem;
         font-weight: bold;
       }
       .company-advantages h3,
       .cases-section h3,
       .contact-section h3 {
         font-size: 1.8rem;
         font-weight: bold;
       }
       .advantages-grid .card,
       .cases-carousel .card,
       .contact-section .form-control {
         height: 100px;
         background-color: #f1f3f5;
       }
       .contact-section .btn {
         margin-top: 1rem;
       }
     </style>
   </head>
   <body>

     <!-- Navbar -->
     <nav class="navbar navbar-expand-lg navbar-light bg-white border-bottom">
       <div class="container">
         <a class="navbar-brand" href="#">COMPANY</a>
         <div class="navbar-nav ms-auto">
           <a class="nav-link" href="#">Company</a>
           <a class="nav-link" href="#">Our Cases</a>
           <a class="nav-link" href="#">Blog</a>
           <a class="nav-link text-primary" href="#">News</a>
           <a class="nav-link" href="#">Contact</a>
           <a class="nav-link ms-4 fw-bold" href="#">999-456-009</a>
         </div>
       </div>
     </nav>

     <!-- Hero Section -->
     <div class="container hero-section my-5">
       <div class="row">
         <div class="col-md-6">
           <h1>Landing Page Template</h1>
           <h4 class="text-muted">Loreipsum Title</h4>
           <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
           <button class="btn btn-primary">Next</button>
         </div>
         <div class="col-md-6">
           <div class="bg-secondary" style="height: 250px;">
             <div class="d-flex justify-content-center align-items-center h-100">
               <i class="bi bi-play-circle" style="font-size: 3rem; color: white;"></i>
             </div>
           </div>
         </div>
       </div>
     </div>

     <!-- Info Section -->
     <div class="container info-section text-center">
       <div class="row">
         <div class="col-md-4">
           <h5>Dolor Fit Bor</h5>
           <div class="card text-muted p-3">Description text goes here.</div>
         </div>
         <div class="col-md-4">
           <h5>Permos Doloros</h5>
           <div class="card text-muted p-3">Description text goes here.</div>
         </div>
         <div class="col-md-4">
           <h5>Goreminot Birju</h5>
           <div class="card text-muted p-3">Description text goes here.</div>
         </div>
       </div>
     </div>

     <!-- Company Advantages Section -->
     <div class="container company-advantages my-5">
       <h3>Company Advantages</h3>
       <div class="row advantages-grid mt-3">
         <div class="col-md-3">
           <div class="card mb-3 p-3">Dolor Fit Bor</div>
           <div class="card mb-3 p-3">Bitus Gorotus</div>
           <div class="card mb-3 p-3">Grobur</div>
         </div>
         <div class="col-md-3">
           <div class="card mb-3 p-3">Posturmat</div>
           <div class="card mb-3 p-3">Fit Bor</div>
           <div class="card mb-3 p-3">Nogits Motpo</div>
         </div>
         <div class="col-md-6">
           <div class="card h-100 bg-secondary text-white p-3">
             <h4 class="mb-4">Lorem Ipsum Dolor</h4>
             <div class="d-flex flex-column">
               <span class="p-2 bg-dark mb-2">Loreipsum</span>
               <span class="p-2 bg-dark mb-2">Dolor</span>
               <span class="p-2 bg-dark">Taurus Bigor</span>
             </div>
           </div>
         </div>
       </div>
     </div>

     <!-- Our Cases Section -->
     <div class="container cases-section text-center my-5">
       <h3>Our Cases</h3>
       <div id="casesCarousel" class="carousel slide mt-4" data-bs-ride="carousel">
         <div class="carousel-inner">
           <div class="carousel-item active">
             <div class="row">
               <div class="col-md-3 mb-3">
                 <div class="card" style="height: 100px; background-color: #ddd;"></div>
               </div>
               <div class="col-md-3 mb-3">
                 <div class="card" style="height: 100px; background-color: #ddd;"></div>
               </div>
               <div class="col-md-3 mb-3">
                 <div class="card" style="height: 100px; background-color: #ddd;"></div>
               </div>
               <div class="col-md-3 mb-3">
                 <div class="card" style="height: 100px; background-color: #ddd;"></div>
               </div>
             </div>
           </div>
         </div>
         <button class="carousel-control-prev" type="button" data-bs-target="#casesCarousel" data-bs-slide="prev">
           <span class="carousel-control-prev-icon" aria-hidden="true"></span>
           <span class="visually-hidden">Previous</span>
         </button>
         <button class="carousel-control-next" type="button" data-bs-target="#casesCarousel" data-bs-slide="next">
           <span class="carousel-control-next-icon" aria-hidden="true"></span>
           <span class="visually-hidden">Next</span>
         </button>
       </div>
     </div>

     <!-- Send Mail Section -->
     <div class="container contact-section my-5 text-center">
       <h3>Send Mail</h3>
       <p class="text-muted">Send us a message with any inquiries you may have.</p>
       <form>
         <div class="mb-3">
           <input type="text" class="form-control" placeholder="Your name">
         </div>
         <div class="mb-3">
           <input type="email" class="form-control" placeholder="Contact mail">
         </div>
         <div class="mb-3">
           <textarea class="form-control" rows="3" placeholder="Message"></textarea>
         </div>
         <button type="submit" class="btn btn-primary">Send Your Message</button>
       </form>
     </div>

     <!-- Footer Section -->
     <footer class="bg-dark text-white py-4 mt-5">
       <div class="container text-center">
         <div class="row">
           <div class="col">
             <div class="nav justify-content-center">
               <a class="nav-link text-white" href="#">Company</a>
               <a class="nav-link text-white" href="#">Our Cases</a>
               <a class="nav-link text-white" href="#">Blog</a>
               <a class="nav-link text-white" href="#">News</a>
               <a class="nav-link text-white" href="#">Contact</a>
             </div>
           </div>
         </div>
         <p class="mt-3">www.company.com</p>
       </div>
     </footer>

     <!-- Bootstrap JS -->
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
   </body>
   </html>
   ```

---

### Explanation of the HTML Structure

- **Navbar**: Contains links aligned to the right with a phone number.
- **Hero Section**: A large banner with title, subtitle, text, and a button on the left; a video placeholder on the right.
- **Info Section**: Three cards in a row for information sections.
- **Company Advantages**: A title followed by a grid layout of cards for different company features.
- **Our Cases Section**: A Bootstrap carousel containing example cases.
- **Send Mail Section**: A contact form


### Design Three:
<img src="https://github.com/meghnadsaha/java-oops/blob/master/resources/web-design/Screenshot%202024-11-11%20at%208.29.10%20PM.png?raw=true"/>

Here is a full layout code for a travel website landing page similar to the image you provided, using both **React Bootstrap** and **plain HTML with Bootstrap**. This layout includes sections for a hero banner, packages, pricing, and tour guides, along with some custom styling in CSS.

---

### React Bootstrap Code

1. **Install Dependencies**:
   Make sure you have `react-bootstrap` and `bootstrap` installed.

   ```bash
   npm install react-bootstrap bootstrap
   ```

2. **App.js** - Main Component Code

   ```javascript
   import React from 'react';
   import { Container, Row, Col, Card, Button } from 'react-bootstrap';
   import './App.css';

   function App() {
     return (
       <Container fluid>
         {/* Hero Section */}
         <Container className="hero-section text-center my-5">
           <Row>
             <Col md={6} className="text-left">
               <h1 className="font-weight-bold">We Make Your Travel More <span className="text-orange">Enjoyable</span></h1>
               <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
               <Button variant="danger" className="my-3">More Info</Button>
             </Col>
             <Col md={6}>
               <Row>
                 {[...Array(4)].map((_, index) => (
                   <Col key={index} md={6} className="mb-3">
                     <Card className="placeholder-card" />
                   </Col>
                 ))}
               </Row>
             </Col>
           </Row>
         </Container>

         {/* Choose Your Package Section */}
         <Container className="text-center my-5">
           <h3 className="text-orange">Dream Vacation Destination</h3>
           <h2 className="font-weight-bold">Choose Your Package</h2>
           <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
           <Row>
             {['Tuscany', 'Tokyo', 'Santa Monica', 'Maldives', 'Seychelles', 'Phuket'].map((location, index) => (
               <Col key={index} md={4} className="mb-3">
                 <Card className="package-card">
                   <Card.Body>
                     <Card.Title>{location}</Card.Title>
                     <Button variant="danger">Learn More</Button>
                   </Card.Body>
                 </Card>
               </Col>
             ))}
           </Row>
         </Container>

         {/* Affordable Travel Packages Section */}
         <Container className="pricing-section text-center my-5">
           <h3 className="text-orange">Clear Prices</h3>
           <h2 className="font-weight-bold">Affordable Travel Packages</h2>
           <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
           <Row>
             {[
               { title: 'Half Board', price: '$50 / Day' },
               { title: 'All Inclusive', price: '$40 / Day', highlight: true },
               { title: 'Excursions Included', price: '$45 / Day' }
             ].map((plan, index) => (
               <Col key={index} md={4} className="mb-3">
                 <Card className={plan.highlight ? 'text-white bg-orange' : ''}>
                   <Card.Body>
                     <Card.Title>{plan.title}</Card.Title>
                     <h3>{plan.price}</h3>
                     <ul>
                       <li>Transfers from Airport</li>
                       <li>Minimum 3-Star Hotel</li>
                       <li>Alcoholic Beverages</li>
                       <li>Meal in Restaurants</li>
                     </ul>
                   </Card.Body>
                 </Card>
               </Col>
             ))}
           </Row>
         </Container>

         {/* Tour Guide Section */}
         <Container className="text-center my-5">
           <h3 className="text-orange">Come With Us</h3>
           <h2 className="font-weight-bold">Tour Guide</h2>
           <Row>
             {['McKinney', 'Charlotte', 'Brooklyn'].map((guide, index) => (
               <Col key={index} md={4} className="mb-3">
                 <Card className="tour-guide-card text-center">
                   <Card.Body>
                     <Card.Title>{guide}</Card.Title>
                     <Button variant="danger">Tour Guide</Button>
                   </Card.Body>
                 </Card>
               </Col>
             ))}
           </Row>
         </Container>

         {/* Footer Section */}
         <footer className="bg-dark text-white py-4">
           <Container className="text-center">
             <p>Address Street Name City Name, Country | info@example.com | (+000) 123 456 789</p>
           </Container>
         </footer>
       </Container>
     );
   }

   export default App;
   ```

3. **App.css** - Custom CSS Styling

   ```css
   /* App.css */
   body {
     background-color: #f8f9fa;
   }

   .font-weight-bold {
     font-weight: bold;
   }

   .text-orange {
     color: #ff6600;
   }

   .bg-orange {
     background-color: #ff6600;
   }

   .hero-section .btn {
     background-color: #ff6600;
     border: none;
   }

   .placeholder-card {
     height: 120px;
     background-color: #e0e0e0;
   }

   .package-card {
     height: 200px;
     display: flex;
     flex-direction: column;
     align-items: center;
     justify-content: center;
     background-color: #f5f5f5;
   }

   .pricing-section ul {
     list-style: none;
     padding: 0;
     font-size: 0.9rem;
   }

   .tour-guide-card {
     height: 200px;
     display: flex;
     flex-direction: column;
     align-items: center;
     justify-content: center;
     background-color: #f5f5f5;
   }

   footer {
     font-size: 0.9rem;
   }
   ```

---

### Plain HTML with Bootstrap Code

Here’s the equivalent layout in plain HTML and Bootstrap.

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Travel Landing Page</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body { background-color: #f8f9fa; }
    .font-weight-bold { font-weight: bold; }
    .text-orange { color: #ff6600; }
    .bg-orange { background-color: #ff6600; }
    .btn-orange { background-color: #ff6600; border: none; }
    .placeholder-card, .package-card, .tour-guide-card { height: 200px; background-color: #e0e0e0; }
    .pricing-section ul { list-style: none; padding: 0; font-size: 0.9rem; }
    footer { font-size: 0.9rem; }
  </style>
</head>
<body>

  <!-- Hero Section -->
  <div class="container text-center my-5">
    <div class="row">
      <div class="col-md-6 text-start">
        <h1 class="font-weight-bold">We Make Your Travel More <span class="text-orange">Enjoyable</span></h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        <button class="btn btn-orange">More Info</button>
      </div>
      <div class="col-md-6">
        <div class="row">
          <div class="col-md-6 placeholder-card mb-3"></div>
          <div class="col-md-6 placeholder-card mb-3"></div>
          <div class="col-md-6 placeholder-card mb-3"></div>
          <div class="col-md-6 placeholder-card mb-3"></div>
        </div>
      </div>
    </div>
  </div>

  <!-- Choose Your Package Section -->
  <div class="container text-center my-5">
    <h3 class="text-orange">Dream Vacation Destination</h3>
    <h2 class="font-weight-bold">Choose Your Package</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    <div class="row">
      <div class="col-md-4 package-card mb-3">Tuscany</div>
      <div class="col-md-4 package-card mb-3">Tokyo</div>
      <div class="col-md-4 package-card mb-3">Santa Monica</div>
      <div class="col-md-4 package-card mb-3">Maldives</div>
      <div class="col-md-4 package-card mb-3">Seychelles</div>
      <div class="col-md-4 package-card mb-3">Phuket</div>
    </div>
  </div>

  <!-- Affordable Travel Packages Section -->
  <div class="container pricing

-section text-center my-5">
    <h3 class="text-orange">Clear Prices</h3>
    <h2 class="font-weight-bold">Affordable Travel Packages</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    <div class="row">
      <div class="col-md-4">
        <div class="card mb-3">
          <div class="card-body">
            <h4>Half Board</h4>
            <h3>$50 / Day</h3>
            <ul><li>Transfers from Airport</li><li>Minimum 3-Star Hotel</li><li>Alcoholic Beverages</li><li>Meal in Restaurants</li></ul>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card bg-orange text-white mb-3">
          <div class="card-body">
            <h4>All Inclusive</h4>
            <h3>$40 / Day</h3>
            <ul><li>Transfers from Airport</li><li>Minimum 3-Star Hotel</li><li>Alcoholic Beverages</li><li>Meal in Restaurants</li></ul>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card mb-3">
          <div class="card-body">
            <h4>Excursions Included</h4>
            <h3>$45 / Day</h3>
            <ul><li>Transfers from Airport</li><li>Minimum 3-Star Hotel</li><li>Alcoholic Beverages</li><li>Meal in Restaurants</li></ul>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Tour Guide Section -->
  <div class="container text-center my-5">
    <h3 class="text-orange">Come With Us</h3>
    <h2 class="font-weight-bold">Tour Guide</h2>
    <div class="row">
      <div class="col-md-4 tour-guide-card">McKinney</div>
      <div class="col-md-4 tour-guide-card">Charlotte</div>
      <div class="col-md-4 tour-guide-card">Brooklyn</div>
    </div>
  </div>

  <!-- Footer Section -->
  <footer class="bg-dark text-white text-center py-4">
    <p>Address Street Name City Name, Country | info@example.com | (+000) 123 456 789</p>
  </footer>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```

This layout includes custom CSS to match the style, with sections for the hero, package choices, pricing, tour guides, and footer. Let me know if you need further adjustments!

### Design Four

<img src="https://github.com/meghnadsaha/java-oops/blob/master/resources/web-design/Screenshot%202024-11-11%20at%208.29.14%20PM.png"/>

Here’s the complete code for a travel website landing page similar to the latest image you provided, using **React Bootstrap** and **plain HTML with Bootstrap**. This design features a hero section with a search bar, a section for popular packages, a promotional banner, a tour guide section, and a footer.

---

### React Bootstrap Code (App.js + App.css)

1. **Install Dependencies**:
   Make sure you have `react-bootstrap` and `bootstrap` installed.

   ```bash
   npm install react-bootstrap bootstrap
   ```

2. **App.js** - Main Component Code

   ```javascript
   import React from 'react';
   import { Container, Row, Col, Card, Button, Form } from 'react-bootstrap';
   import './App.css';

   function App() {
     return (
       <Container fluid>
         {/* Hero Section */}
         <div className="hero-section text-center text-white py-5">
           <h1 className="display-4 font-weight-bold">We Make Your Travel More Enjoyable</h1>
           <Form className="search-form mt-4 mx-auto">
             <Form.Control type="text" placeholder="Search Location" className="rounded-pill px-4" />
           </Form>
         </div>

         {/* Most Popular Packages Section */}
         <Container className="text-center my-5">
           <h2 className="font-weight-bold">Most Popular Packages</h2>
           <Row className="mt-4">
             {['Tuscany, Italy', 'Tokyo, Japan', 'Monica, California', 'Maldives, Oceania', 'Seychelles', 'Phuket, Thailand'].map((location, index) => (
               <Col key={index} md={4} className="mb-4">
                 <Card className="package-card">
                   <Card.Img variant="top" src="placeholder.png" className="img-fluid" />
                   <Card.Body>
                     <Card.Title>{location}</Card.Title>
                     <Card.Text>3 Night Stay (Apartment) | Sports City | 5 Star Quality</Card.Text>
                     <p>From $90.00</p>
                   </Card.Body>
                 </Card>
               </Col>
             ))}
           </Row>
         </Container>

         {/* Promotion Banner */}
         <div className="promotion-banner text-white text-center py-5">
           <h2>Up to 45% off on your favourite Destination</h2>
           <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
           <Button variant="dark" className="rounded-pill">Book Now</Button>
         </div>

         {/* Tour Guide Section */}
         <Container className="text-center my-5">
           <h2 className="font-weight-bold">Tour Guide</h2>
           <Row className="mt-4">
             {['McKinney', 'Charlotte', 'Brooklyn'].map((guide, index) => (
               <Col key={index} md={4} className="mb-4">
                 <Card className="tour-guide-card">
                   <Card.Img variant="top" src="placeholder.png" className="img-fluid" />
                   <Card.Body>
                     <Card.Title>{guide}</Card.Title>
                     <Card.Text>Tour Guide</Card.Text>
                     <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                   </Card.Body>
                 </Card>
               </Col>
             ))}
           </Row>
         </Container>

         {/* Footer Section */}
         <footer className="bg-dark text-white text-center py-4">
           <Container>
             <p>Address Street Name City Name, Country | info@example.com | (+000) 123 456 789</p>
           </Container>
         </footer>
       </Container>
     );
   }

   export default App;
   ```

3. **App.css** - Custom CSS Styling

   ```css
   /* App.css */
   body {
     background-color: #f8f9fa;
   }

   .hero-section {
     background-color: #f7b731;
   }

   .search-form {
     max-width: 500px;
   }

   .package-card, .tour-guide-card {
     border: none;
     text-align: left;
   }

   .promotion-banner {
     background: linear-gradient(90deg, #f7b731, #ffab00);
   }

   footer {
     font-size: 0.9rem;
   }
   ```

---

### Plain HTML with Bootstrap Code

Here’s the equivalent layout in plain HTML and Bootstrap.

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Travel Landing Page</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body { background-color: #f8f9fa; }
    .hero-section { background-color: #f7b731; color: white; padding: 3rem 0; }
    .search-form { max-width: 500px; margin: auto; }
    .promotion-banner { background: linear-gradient(90deg, #f7b731, #ffab00); color: white; padding: 3rem 0; }
    footer { font-size: 0.9rem; }
  </style>
</head>
<body>

  <!-- Hero Section -->
  <div class="hero-section text-center">
    <h1 class="display-4 font-weight-bold">We Make Your Travel More Enjoyable</h1>
    <form class="search-form mt-4">
      <input type="text" class="form-control rounded-pill px-4" placeholder="Search Location">
    </form>
  </div>

  <!-- Most Popular Packages Section -->
  <div class="container text-center my-5">
    <h2 class="font-weight-bold">Most Popular Packages</h2>
    <div class="row mt-4">
      <div class="col-md-4 mb-4">
        <div class="card">
          <img src="placeholder.png" class="card-img-top" alt="Tuscany">
          <div class="card-body">
            <h5 class="card-title">Tuscany, Italy</h5>
            <p>3 Night Stay (Apartment) | Sports City | 5 Star Quality</p>
            <p>From $90.00</p>
          </div>
        </div>
      </div>
      <div class="col-md-4 mb-4">
        <div class="card">
          <img src="placeholder.png" class="card-img-top" alt="Tokyo">
          <div class="card-body">
            <h5 class="card-title">Tokyo, Japan</h5>
            <p>3 Night Stay (Apartment) | Sports City | 5 Star Quality</p>
            <p>From $90.00</p>
          </div>
        </div>
      </div>
      <div class="col-md-4 mb-4">
        <div class="card">
          <img src="placeholder.png" class="card-img-top" alt="Monica">
          <div class="card-body">
            <h5 class="card-title">Monica, California</h5>
            <p>3 Night Stay (Apartment) | Sports City | 5 Star Quality</p>
            <p>From $90.00</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Promotion Banner -->
  <div class="promotion-banner text-center">
    <h2>Up to 45% off on your favourite Destination</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <button class="btn btn-dark rounded-pill">Book Now</button>
  </div>

  <!-- Tour Guide Section -->
  <div class="container text-center my-5">
    <h2 class="font-weight-bold">Tour Guide</h2>
    <div class="row mt-4">
      <div class="col-md-4 mb-4">
        <div class="card">
          <img src="placeholder.png" class="card-img-top" alt="McKinney">
          <div class="card-body">
            <h5 class="card-title">McKinney</h5>
            <p>Tour Guide</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </div>
        </div>
      </div>
      <div class="col-md-4 mb-4">
        <div class="card">
          <img src="placeholder.png" class="card-img-top" alt="Charlotte">
          <div class="card-body">
            <h5 class="card-title">Charlotte</h5>
            <p>Tour Guide</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </div>
        </div>
      </div>
      <div class="col-md-4 mb-4">
        <div class="card">
          <img src="placeholder.png" class="card-img-top" alt="Brooklyn">
          <div class="card-body">
            <h5 class="card-title">Brooklyn</h5>
            <p>Tour Guide</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Footer Section -->
  <

footer class="bg-dark text-white text-center py-4">
    <div class="container">
      <p>Address Street Name City Name, Country | info@example.com | (+000) 123 456 789</p>
    </div>
  </footer>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```

This HTML and React layout uses Bootstrap to create a travel page with structured sections. Each section is styled with appropriate classes and custom CSS to match the look of your provided design. Let me know if you need any further adjustments!




