# CISC Assignments

An archive of Python and Java coursework and a Flask library management project, consolidated into one repository.

## Features

- CISC 101 Python assignments, practice exercises, and word-processing data.
- CISC 121 Python assignments and sorting/searching exercises.
- CISC 124 Java assignments and workshop exercises.
- CISC 327 library management application with unit, integration, and browser tests.
- Original repository histories preserved as portable Git bundles.

## Quick start

Each course is independent; run assignments from their own directories so relative data paths resolve correctly.
There is no shared build or dependency installation.

For the library management application, install Python and run these commands from the repository root:

```sh
cd CISC-327/library-management
python -m venv .venv
```

Activate the environment with `.venv\Scripts\Activate.ps1` in PowerShell or `source .venv/bin/activate` on macOS/Linux, then run:

```sh
python -m pip install -r requirements.txt
python app.py
```

Open [the local catalog](http://127.0.0.1:5000/catalog).
The application initializes its SQLite database and sample data at startup.

Python exercises run with `python <filename>.py` from the exercise directory.
Java exercises require a JDK; compile with `javac *.java` inside an individual assignment or workshop directory, then run its class containing `main`.
Keep Java assignment directories separate when compiling.

## Docs

| Course | Contents |
| --- | --- |
| [CISC 101](CISC-101/) | Python assignments 6-9, practice exercises, and text fixtures. |
| [CISC 121](CISC-121/) | Assignment 1, extra exercises, grades fixture, and algorithm practice. |
| [CISC 124](CISC-124/) | Three Java assignments and a car/driver workshop. |
| [CISC 327](CISC-327/library-management/) | Flask/SQLite library management project and its original coursework materials. |

For CISC 327, see the [requirements](CISC-327/library-management/requirements_specification.md) and [student instructions](CISC-327/library-management/student_instructions.md).

## Archive and provenance

Coursework is retained as historical material, including unfinished exercises and intentional defects in the library project.
Original assignment filenames and internal directory layouts are preserved.
The nested `.github/workflows` files are retained as historical configuration; GitHub Actions only runs workflows in the root `.github/workflows` directory.

| Original repository | Archive location | History |
| --- | --- | --- |
| [CISC-101-Assighnments](https://github.com/RadmehrVafadar/CISC-101-Assighnments) | `CISC-101/` | [Git bundle](archive/git-history/cisc-101.bundle) |
| CISC 121 files already in this repository | `CISC-121/` | Parent repository history |
| [CISC-124](https://github.com/RadmehrVafadar/CISC-124) | `CISC-124/` | [Git bundle](archive/git-history/cisc-124.bundle) |
| [cisc327-library-management](https://github.com/RadmehrVafadar/cisc327-library-management) | `CISC-327/library-management/` | [Git bundle](archive/git-history/cisc-327.bundle) |

The bundles contain all refs exported from the three local source repositories at consolidation.
They preserve separate histories without embedding repositories or requiring submodules.
To inspect or restore one, run from the repository root:

```sh
git bundle verify archive/git-history/cisc-101.bundle
git clone archive/git-history/cisc-101.bundle ../cisc-101-history
```

Substitute the corresponding bundle for CISC 124 or CISC 327.
Local original Git metadata is also retained in the ignored `.archive-git/` directory; portable history is in the tracked bundles.

## Validation

From `CISC-327/library-management/`, the non-browser test command is:

```sh
python -m pytest --ignore=tests/test_e2e.py
```

The historical Python browser tests additionally need Playwright, its pytest plugin, browser binaries, and a running application.
They use a visible browser and depend on catalog state.
The separate Node Playwright configuration points to an absent `e2e/` directory.
These historical test setups are preserved as submitted.
