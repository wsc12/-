$(function () {

	 $(".col-1").load("menu.html",function(){
		 
	
     $(".col-2").load("model-items.html",function () {
    	 //////////////////////////start
         $(".models").addClass("hidden");
         $(".models").eq(0).removeClass("hidden");
     	
    $(".models").addClass("hidden");
    $(".models").eq(0).removeClass("hidden");
    $(".img  .thumbnail").click(function(){

        $(this).prev().click();

    })
    $(".img  .thumbnail").prev().change(function(){
        var $img=$(this).next().find('img');

        var file=this.files[0];
        var reader=new FileReader();
        reader.readAsDataURL(file);
        reader.onloadend=function(){
            $img[0].src=reader.result;
        }


    })


    $("#upload").click(function(){
        var fd=new FormData();
        var file=new Array();
        var fs=$(".img  input[type=file]");


        for(var i=0;i<fs.length;i++)
        {

            file[i]=fs[i].files[0];
            fd.append('file[]',file[i]);
        }

        $.ajax({
            url: 'http://localhost:8080/Hotel/upload',
            type: 'POST',
            data:fd,
            async:false,
            cache:false,
            contentType:false,
            processData:false,
            success:function(data){

               
            },
            error:function (data) {
                console.log(data);
            }
        })




    })

    function onloadImg() {

        $.post('http://localhost:8080/Hotel/onloadImg',{belong:'B304'},function (data) {

            $.each(data,function (index,el) {



                $(".img  .thumbnail img")[data.length-index-1].src="http://localhost:8080/Hotel/"+el;
            })


        })

    }



    onloadImg();







    var totalHeight=document.documentElement.clientHeight;
    var headerHeight=$(".header").outerHeight();
    $(".col-1").height(totalHeight-headerHeight+50);
    $(".col-2").height(totalHeight-headerHeight+50);
    $(".menu").next().css('display','none');
    $(".menu").click(function(){
        $(".menu").next().not($(this).next()).slideUp('low');
        $(this).next().slideToggle('low');

    });


    $(".items").click(function (){

        $(".models").addClass("hidden");
        var index=$('.items').index(this);

        $(".models").eq(index).removeClass("hidden");

    })
    ///////////////////////////end///////////////////////////////
     });
	 });
})