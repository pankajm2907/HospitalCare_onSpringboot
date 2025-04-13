#!/bin/bash

echo "🌀 Starting port-forwarding for hospital services..."

# Format: service name : local port : service port
services=(
  "api-gateway:8080:8080"
  "appointment-service:8083:8083"
  "billing-service:8084:8084"
  "config-server:8888:8888"
  "doctor-service:8082:8082"
  "eureka-server:8761:8761"
  "mysql:3306:3306"
  "patient-service:8081:8081"
  "swagger-aggregator:9090:9090"
)

for svc in "${services[@]}"; do
  IFS=":" read -r name local_port svc_port <<< "$svc"
  echo "🔗 Forwarding $name → localhost:$local_port"
  kubectl port-forward service/$name $local_port:$svc_port &
kubectl port-forward svc/prometheus-service 19090:9090
kubectl port-forward svc/grafana-service 13000:3000



done

echo "✅ All port-forwards are launching. You can now access services locally."
echo "🛑 To stop them: run 'killall kubectl'"
