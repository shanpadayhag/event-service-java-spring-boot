<!-- Improved compatibility of back to top link: See: https://github.com/shanpadayhag/Best-README-Template/pull/73 -->
<a id="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![Unlicense License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/shanpadayhag/event-service-java-spring-boot">
    <img src="public/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Event Service</h3>

  <p align="center">
    A simple event service API built with Spring Boot.
    <br />
    <a href="https://github.com/shanpadayhag/event-service-java-spring-boot"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/shanpadayhag/event-service-java-spring-boot">View Demo</a>
    ·
    <a href="https://github.com/shanpadayhag/event-service-java-spring-boot/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    ·
    <a href="https://github.com/shanpadayhag/event-service-java-spring-boot/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
         <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://example.com)

This project is a simple RESTful API for managing events. It is built using Spring Boot and provides endpoints for retrieving events based on a given year and month. This service is intended to be used as a backend for event management systems.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

This section lists the major frameworks and libraries used to build the project.

*   [![Spring Boot][springboot.io]][springboot-url]
*   [![Maven][maven.apache.org]][maven-url]
*   [![MySQL][mysql.com]][mysql-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

Make sure you have the following installed:

*   Java JDK (version 23 or higher)
*   [Maven](https://maven.apache.org/download.cgi)
*   MySQL Database

### Installation

1.  Clone the repository:
    ```sh
    git clone https://github.com/shanpadayhag/event-service-java-spring-boot.git
    ```
2.  Navigate to the project directory:
    ```sh
    cd event-service-java-spring-boot
    ```
3.  Install Maven dependencies:
    ```sh
    mvn install
    ```
4.  Copy the example application properties file and reconfigure:
    ```sh
    cp src/main/resources/application.example.properties src/main/resources/application.properties
    ```
    *(You might need to update the database configuration inside `src/main/resources/application.properties`)*
5. Run the application:
    ```sh
    mvn spring-boot:run
    ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->
## Usage

The application provides a RESTful API for retrieving events.

*   **Get Events**:

    ```
    GET /api/v1/events
    ```
    Optional query parameters: `year`, `month`. If none is provided, defaults to current year and month.
    Example:

     - `GET /api/v1/events?year=2024&month=03` Get events for March of 2024.
     - `GET /api/v1/events?month=03` Get events for March of the current year.
     - `GET /api/v1/events?year=2024` Get events for the current month of the year 2024.
     - `GET /api/v1/events` Get events for the current month of the current year.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ROADMAP -->
## Roadmap

Here's a list of future plans for the project:

- [ ] Implement authentication and authorization.
- [ ] Add endpoints for creating, updating, and deleting events.
- [ ] Improve error handling and response messages.
- [ ] Add unit tests.
- [ ] Add integration tests.
- [ ] Refactor to use DTOs for all operations.

See the [open issues](https://github.com/shanpadayhag/event-service-java-spring-boot/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->
## Contributing

Contributions are welcome! If you have any suggestions or improvements, feel free to fork the repository and create a pull request.

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

### Top contributors:
<!-- Add the contributors image when available -->
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->
## License

Distributed under the Unlicense License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Shan Padayhag - [@your_twitter](https://twitter.com/shanpadayhag) - email@example.com

Project Link: [https://github.com/shanpadayhag/event-service-java-spring-boot](https://github.com/shanpadayhag/event-service-java-spring-boot)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Here are some resources that were helpful during the development of this project:

*   [Choose an Open Source License](https://choosealicense.com)
*   [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
*   [Spring Boot Documentation](https://spring.io/projects/spring-boot)
*   [Maven Documentation](https://maven.apache.org/guides/index.html)
*   [MySQL Documentation](https://dev.mysql.com/doc/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/shanpadayhag/event-service-java-spring-boot?style=for-the-badge
[contributors-url]: https://github.com/shanpadayhag/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/shanpadayhag/event-service-java-spring-boot?style=for-the-badge
[forks-url]: https://github.com/shanpadayhag/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/shanpadayhag/event-service-java-spring-boot?style=for-the-badge
[stars-url]: https://github.com/shanpadayhag/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/shanpadayhag/event-service-java-spring-boot?style=for-the-badge
[issues-url]: https://github.com/shanpadayhag/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/shanpadayhag/event-service-java-spring-boot?style=for-the-badge
[license-url]: https://github.com/shanpadayhag/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/shanpadayhag
[product-screenshot]: public/screenshot.png
[springboot.io]: https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[springboot-url]: https://spring.io/projects/spring-boot
[maven.apache.org]: https://img.shields.io/badge/Apache_Maven-C43025?style=for-the-badge&logo=apache-maven&logoColor=white
[maven-url]: https://maven.apache.org/
[mysql.com]: https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white
[mysql-url]: https://www.mysql.com/
