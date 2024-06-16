# root/root123456
docker run --name mySQL -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root123456 -d mysql:8
docker run --name mySQL -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root123456 -v /Users/erenwu/Docker/volume/mysql:/var/lib/mysql -d mysql:8
