<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
      <script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
      <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />
    </head>
    <body class="antialiased">


      <div class="my-dropzone"></div>

      <form action="/api/upload/media/172200001540032/append?segment_index=0"
      class="dropzone"
      id="my-great-dropzone"></form>

      <script>
        Dropzone.options.myGreatDropzone = {
          paramName: "media",
          maxFilesize: 20,
          chunking: true,
          chunkSize: 100000,
          parallelChunkUploads: true,
          headers: {
            'authorization': 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vMTI3LjAuMC4xOjgwMDAvYXBpL2FjY291bnQvbG9naW4iLCJpYXQiOjE2NDgyMjM5MjksImV4cCI6MTY3OTc1OTkyOSwibmJmIjoxNjQ4MjIzOTI5LCJqdGkiOiJCdmZtdUc5TmFnamxOVzFXIiwic3ViIjoiMTcyMjAwMTY5MDA0MSIsInBydiI6ImY2NzYzOGEzMjZlMGE1OGU5MzY3NDZhZWZkM2RlNWM1MjAzYWMyOTEifQ.Gs0JpnmraIrJeZYhxF2jdFabLgONfnzdbP8oHaYpw-M'
          },
          accept: function(file, done) {
            if (file.name == "justinbieber.jpg") {
              done("Naha, you don't.");
            }
            else { done(); }
          }
        };
      </script>
    </body>
</html>
