Group: L57
Members:
	- 76546 Manuel Marcos
	- 80013 Dimtiri da Silva

Build and run project and all dependencies: docker-compose up
Ports used:
- Spring: 8000

REST Endpoints:
- Real time information: http://localhost:8000/weather/search/{city}
- Historic information: http://localhost:8000/weather/search/history/{city}

Websocket Endpoints:
- http://localhost:8000/websocket

Real time and historic data UI: ui/index.html
Logs and real time events UI: ui/logs.html