# URLShortening

<h3>프로젝트 기능</h3>
<ul>
<li>URL 입력폼 제공 및 Shortening 결과출력</li>
<li>동일한 URL에 대한 요청시 동일한 Shortening Key로 응답하며 요청 수 정보를 제공</li>
<li>Shortening된 URL을 요청받으면 원래 URL로 리다이렉트</li>
</ul>

<h4>git 설치</h4>
sudo apt-get install git-core

<h4>Github 개인 정보 등록</h4>
sudo git config --global user.name "본인 계정 입력"
sudo git config --global user.email "본인 메일 주소 입력"

<h4>Github 저장소 복제</h4>
sudo git clone https://github.com/woogie14/URLShortening.git

<h4>java 설치</h4>
sudo apt-get install openjdk-8-jre
sudo apt-get install openjdk-8-jdk

<h4>java path설정</h4>
sudo nano /etc/profile
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
export CLASS_PATH=$JAVA_HOME/lib:$CLASS_PATH
source /etc/profile
sudo reboot now


<h4>maven 설치</h4>
sudo apt install maven

<h4>패키징</h4>
mvn package

<h4>jar 실행</h4>
java -jfar URLShortening-0.0.1-SNAPSHOT.jar
