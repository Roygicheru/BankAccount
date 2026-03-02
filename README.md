This is a Java project meant to demonstrate CI functionality using Jenkins.

Step 1:
--------
Created an ngrok account by connecting it to my GitHub.

Step 2:
-------
Downloaded ngrok archive with command: "curl -sSLO https://bin.equinox.io/c/bNyj1mQVY4c/ngrok-v3-stable-linux-amd64.tgz"

Extracted it directly into my executable path: "sudo tar -xvzf ngrok-v3-stable-linux-amd64.tgz -C /usr/local/bin"

Verified installation: "ngrok --version"

Ran the following command to add your authtoken to the default ngrok.yml configuration file.
"ngrok config add-authtoken 3AP5iqiTcn6CJf1B6y5hVBI3cCr_46ngzAtwazLwZi4Seqkbt"

Ran : "ngrok http 8080"

Step 3:
-------

