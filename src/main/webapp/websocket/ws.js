window.onload = function() {
    console.log('Play WebSocket');
    var context_path = '/JavaWeb1122';
    var websocket_path = '/websocket/server';
    var url = 'ws://' + window.location.hostname + ':' + window.location.port + context_path + websocket_path;
    var webSocket;
    
    openBtn.addEventListener("click", function () {
        setWebSocket();
    });
    
    messageBtn.addEventListener("click", function () {
        
    });
    
    closeBtn.addEventListener("click", function () {
        webSocket.close();
    });
    
    //設置 WebSocket
    function setWebSocket() {
        // 設定 websocket 物件
        webSocket = new WebSocket(url);
        
        // onopen , 連線成功時觸發
        webSocket.onopen = function (event) {
            console.log('連線成功');
            openBtn.disabled = true;
            messageBtn.disabled = false;
            closeBtn.disabled = false;
        };

        // onmessage , 接收到來自Server的訊息時觸發
        webSocket.onmessage = function (event) {
            
            
        };

        // onclose , 連線關閉時觸發  
        webSocket.onclose = function (event) {
            console.log('關閉連線');
            openBtn.disabled = false;
            messageBtn.disabled = true;
            closeBtn.disabled = true;
            messageDisplay.innerHTML = '';
        };
        
        // onerror , 連線錯誤時觸發  
        webSocket.onerror = function (event) {
        };
    }
    
    console.log('init');
    setWebSocket();
    
}