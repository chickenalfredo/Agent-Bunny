# Agent Bunny

[![Build Status](https://travis-ci.org/chickenalfredo/Agent-Bunny.svg?branch=master)](https://travis-ci.org/chickenalfredo/Agent-Bunny) [![codecov](https://codecov.io/gh/chickenalfredo/Agent-Bunny/branch/master/graph/badge.svg)](https://codecov.io/gh/chickenalfredo/Agent-Bunny) [![Maintainability](https://api.codeclimate.com/v1/badges/d9de356771eaa51fd800/maintainability)](https://codeclimate.com/github/chickenalfredo/Agent-Bunny/maintainability)

Agent Bunny is a 2D-platformer style game. The player starts off on a 2D-level map where they must venture to the end of the map, much like the classic Mario platformer games. As the player makes their way to the end of the map, they must battle various enemies and overcome obstacles before coming to the end of the map. The player must also battle a boss before being able to continue and move onto the next map. 

## Getting Started

Installation requires Git and triggers `git clone`. Building the project requires Maven and triggers `mvn package` and `mvn exec:java`.

### Prerequisites

- [Apache Maven](https://maven.apache.org/install.html) 
- [Git](https://git-scm.com/)

### Installing

To begin installation, you must first clone the git repository.

```
git clone https://github.com/chickenalfredo/Agent-Bunny.git
cd Agent-Bunny
```

Once you have successfully cloned the repository and navigated to the root directory, build the project and execute to run the program.
Note: Executing the project will only build and run the executable, but will not concurrently run tests.

```
mvn exec:java
```

## Running the tests

To run the unit tests, navigate to the root directory and run the test command

```
mvn test
```

If you wish build and test all in one command, then run

```
mvn package
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

Please read [CONTRIBUTING.md](https://github.com/chickenalfredo/Animation-Game/blob/master/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

* [**Cloudy Young**](https://github.com/CloudyYoung)
* [**Daniel Contreras**](https://github.com/DanielContreras)
* [**Brett Paffrath**](https://github.com/BrettPaffrath)
* [**Harry**](https://github.com/HeDoLe)

## References

Please read [REFERENCES.md](https://github.com/chickenalfredo/Animation-Game/blob/master/REFERENCES.md) for an updated list of all sources used in the project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/chickenalfredo/Animation-Game/blob/master/LICENSE.md) file for details
