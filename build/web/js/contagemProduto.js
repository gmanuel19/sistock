function carregaIdProduto(codigo){
        //var idProduto = document.getElementById("prodId").value;
        document.getElementById("produtoId").value = codigo;
}

function carregaSaldoProduto(saldo){
    document.getElementById("getProdutoSaldo").value = saldo;
}

function onlynumber(evt) {
   var theEvent = evt || window.event;
   var key = theEvent.keyCode || theEvent.which;
   key = String.fromCharCode( key );
   //var regex = /^[0-9.,]+$/;
   var regex = /^[0-9.]+$/;
   if( !regex.test(key) ) {
      theEvent.returnValue = false;
      if(theEvent.preventDefault) theEvent.preventDefault();
   }
}