#!/bin/bash

CLUSTER_NAME="hospital-cluster"

echo "💥 Deleting old cluster (if any)..."
kind delete cluster --name $CLUSTER_NAME

echo "🚀 Creating new cluster..."
kind create cluster --name $CLUSTER_NAME

echo "📦 Loading Docker images..."
kind load docker-image msa_project_pms_final-api-gateway --name $CLUSTER_NAME
kind load docker-image msa_project_pms_final-appointment-service --name $CLUSTER_NAME
kind load docker-image msa_project_pms_final-billing-service --name $CLUSTER_NAME
kind load docker-image msa_project_pms_final-config-server --name $CLUSTER_NAME
kind load docker-image msa_project_pms_final-doctor-service --name $CLUSTER_NAME
kind load docker-image msa_project_pms_final-eureka-server --name $CLUSTER_NAME
kind load docker-image msa_project_pms_final-patient-service --name $CLUSTER_NAME
kind load docker-image msa_project_pms_final-swagger-aggregator --name $CLUSTER_NAME

echo "📁 Applying Kubernetes deployment YAMLs..."
kubectl apply -f mysql-deployment.yaml
kubectl apply -f eureka-server-deployment.yaml
kubectl apply -f config-server-deployment.yaml
kubectl apply -f patient-service-deployment.yaml
kubectl apply -f doctor-service-deployment.yaml
kubectl apply -f appointment-service-deployment.yaml
kubectl apply -f billing-service-deployment.yaml
kubectl apply -f api-gateway-deployment.yaml
kubectl apply -f swagger-aggregator-deployment.yaml
kubectl apply -f redis-deployment.yaml
kubectl apply -f prometheus-config.yaml
kubectl apply -f prometheus-deployment.yaml
kubectl apply -f prometheus-service.yaml
kubectl apply -f grafana-deployment.yaml
kubectl apply -f grafana-service.yaml


echo "🎯 All services deployed! Use 'kubectl get pods' to check status."
