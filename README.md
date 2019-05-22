# record-parser

Parses records

### Command line

Run the project directly for command line:

    $ boot run -a ./path-to-file.txt -a <last|gender|birthdate>

Run the project's tests:

    $ boot test

### Web

Run the project directly for web:

    $ boot run-web

## Examples

Console version:

    $ boot run -a ./path-to-records.txt birthdate

Web version:

    $ curl -d "first last male red 1990-01-01" http://localhost:3000/records

    $ curl http://localhost:3000/records/gender

## License

Copyright © 2019

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
