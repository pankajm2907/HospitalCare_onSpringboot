#!/bin/bash

# Path to your project
cd ~/Desktop/MSAProjectFInal/MSA_Project_PMS_Final || {
  echo "❌ Project folder not found. Check your path!"
  exit 1
}

echo "🚀 Starting Hospital Cluster..."
./start-hospital-cluster.sh

echo "🕒 Waiting for services to stabilize..."
sleep 10  # Adjust as needed if services take longer to start

echo "🌐 Port forwarding all hospital services..."
./port-forward-hospital.sh
