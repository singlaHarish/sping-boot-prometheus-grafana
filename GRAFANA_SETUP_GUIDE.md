# Grafana Dashboard Setup Guide

## Step 1: Access Grafana
1. Open your browser and go to: **http://localhost:3000**
2. Login with:
   - Username: `admin`
   - Password: `admin`
3. You'll be prompted to change the password (you can skip this for now)

## Step 2: Add Prometheus Data Source
1. Click on **"Configuration"** (gear icon) in the left sidebar
2. Click **"Data Sources"**
3. Click **"Add data source"**
4. Select **"Prometheus"**
5. In the URL field, enter: `http://prometheus:9090`
6. Click **"Save & Test"** - you should see "Data source is working"

## Step 3: Import Dashboard
1. Click **"+"** (plus icon) in the left sidebar
2. Click **"Import"**
3. Click **"Upload JSON file"** and select the `grafana-dashboard.json` file
4. Click **"Load"**
5. Click **"Import"**

## Step 4: View Your Dashboard
Your dashboard will show:
- **Counter Current Value**: Real-time counter value
- **Counter Value Over Time**: Line chart showing counter changes
- **Counter Increment Rate**: How fast the counter is being incremented

## Step 5: Generate Data
To see the dashboard in action, run these commands in PowerShell:

```powershell
# Increment counter multiple times
curl -Method POST http://localhost:8080/counter/increment
curl -Method POST http://localhost:8080/counter/increment
curl -Method POST http://localhost:8080/counter/increment
```

## Dashboard Features
- **Auto-refresh**: Dashboard updates every 5 seconds
- **Time range**: Shows last 5 minutes by default
- **Real-time**: See counter changes immediately
- **Rate calculation**: Shows increment velocity

## Troubleshooting
- If no data appears, wait 10-15 seconds for Prometheus to scrape
- Make sure Spring Boot app is running on port 8080
- Check that Prometheus data source URL is correct