#!/bin/bash

# ASCII Art: Doctor with syringe
cat << "EOF"
        _                     _ _        _ 
| |                   (_) |      | |
| |__   ___  ___ _ __  _| |_ __ _| |
| '_ \ / _ \/ __| '_ \| | __/ _` | |
| | | | (_) \__ \ |_) | | || (_| | |
|_| |_|\___/|___/ .__/|_|\__\__,_|_|
                | |                 
                |_|                    👨‍⚕️💉  Let's heal some services!
         ,''@,
         |.~.|
         : - :
          \-/
       .-|\_/)-.
      /  | Y -- \
     / /\o    /\ \
     \ \_|___|_/ /
      \_/     \_/
        |  _  |
        |  |  |
        (  |  )
        |  |  |
        |  |  |
        |__|__|
        (__|__)

EOF

# Path to your project
cd ~/Desktop/MSAProjectFInal/MSA_Project_PMS_Final || {
  echo "❌ Project folder not found. Check your path!"
  exit 1
}

echo -e "\n🚀 Starting Hospital Cluster..."
./start-hospital-cluster.sh

# Countdown with loading bar
echo -e "\n🕒 Waiting for services to stabilize (120s)..."
for i in {1..120}; do
    printf "\r[%-120s] %d%%" $(printf "#%.0s" $(seq 1 $i)) $((i * 100 / 120))
    sleep 1
done
echo -e "\n✅ Services should be ready!"

echo -e "\n🌐 Port forwarding all hospital services..."
./port-forward-hospital.sh
