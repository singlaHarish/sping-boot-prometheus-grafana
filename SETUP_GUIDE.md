# Spring Boot Counter with Prometheus & Grafana Setup

## What We've Built ✅

### 1. Spring Boot Application with Metrics
- **Counter API**: POST `/counter/increment` and GET `/counter`
- **Prometheus Metrics**: Available at `/actuator/prometheus`
- **Custom Metrics**:
  - `api_counter_increments_total` - Total number of increments
  - `api_counter_current_value` - Current counter value

### 2. Test the Metrics
```bash
# Increment counter
curl -X POST http://localhost:8080/counter/increment

# Check current value
curl http://localhost:8080/counter

# View Prometheus metrics
curl http://localhost:8080/actuator/prometheus | findstr api_counter
```

## Next Steps: Install Docker & Run Monitoring Stack

### 1. Install Docker Desktop
- Download from: https://www.docker.com/products/docker-desktop/
- Install and restart your computer

### 2. Start Prometheus & Grafana
```bash
docker compose up -d
```

### 3. Access Services
- **Prometheus**: http://localhost:9090
- **Grafana**: http://localhost:3000 (admin/admin)

### 4. Configure Grafana Dashboard
1. Add Prometheus data source: http://prometheus:9090
2. Create dashboard with queries:
   - `api_counter_current_value` - Current counter value
   - `rate(api_counter_increments_total[5m])` - Increment rate per second

## Current Status
✅ Spring Boot app running on port 8080
✅ Prometheus metrics endpoint working
✅ Custom counter metrics exposed
⏳ Docker installation needed for monitoring stack