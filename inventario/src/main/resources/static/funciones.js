function eliminar(index_id) {
    console.log(index_id);
    swal({
        title: "Esta seguro de eliminar?",
        text: "Una vez eliminado, no podrá recuperar este registro!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((OK) => {
        if (OK) {
            $.ajax({
                url:"/eliminar/"+index_id,
                success: function(res) {
                    console.log(res);
                },
            });
          swal("Se ha borrado el registro satisfactoriamente", {
            icon: "success",
          }).then((ok)=>{
            if (ok){
                location.href="/listar";
            }
          });
        }
      });
}