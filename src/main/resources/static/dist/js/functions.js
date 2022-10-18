$.get("/user", function(data) {
  $("#user").html(data.name);
  $("#user2").html(data.name);
});

var logout = function() {
  $.post("/logout", function() {
    window.location.href = "/login";
  })
  return true;
}


$.ajaxSetup({
    beforeSend : function(xhr, settings) {
      if (settings.type == 'POST' || settings.type == 'PUT'
          || settings.type == 'DELETE') {
        if (!(/^http:.*/.test(settings.url) || /^https:.*/
          .test(settings.url))) {
          // Only send the token to relative URLs i.e. locally.
          xhr.setRequestHeader("X-XSRF-TOKEN",
            Cookies.get('XSRF-TOKEN'));
        }
      }
    }
});

function createTool() {
  $.validator.setDefaults({
    submitHandler: function () {
      swal({
        title: "¡Buen trabajo!",
        text: "¡Creaste una herramienta!",
        icon: "success",
        button: "Ver lista",
      }).then(function() {
        window.location = "../../pages/tools/show-tools.html";
      });
    }
  });
  $('#create-tool').validate({
    rules: {
      marca: {
        required: true,
        maxlength: 45
      },
      nombre: {
        required: true,
        maxlength: 45
      },
      ano: {
        required: true,
        maxlength: 4
      },
      categoria: {
        required: true,
      },
      descripcion: {
        required: true,
        maxlength: 250
      },
    },
    messages: {
      marca: {
        required: "Por favor ingrese la marca",
        maxlength: "La marca no debe superar los 45 caracteres"
      },
      nombre: {
        required: "Por favor ingrese el nombre",
        minlength: "El nombre no debe superar los 45 caracteres"
      },
      ano: {
        required: "Por favor ingrese el año",
        maxlength: "El año no debe superar los 4 caracteres"
      },
      descripcion: {
        required: "Por favor ingrese la descripción",
        minlength: "la descripción no debe superar los 250 caracteres"
      },
      categoria: {
        required: "Por favor, seleccione la categoría",
      },
    },
    errorElement: 'span',
    errorPlacement: function (error, element) {
      error.addClass('invalid-feedback');
      element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass) {
      $(element).addClass('is-invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
      $(element).removeClass('is-invalid');
    }
  });
}

function createCategory() {
  $.validator.setDefaults({
    submitHandler: function () {
      swal({
        title: "¡Buen trabajo!",
        text: "¡Creaste una categoría!",
        icon: "success",
        button: "Ver lista",
      }).then(function() {
        window.location = "../../pages/categories/show-categories.html";
      });
    }
  });
  $('#create-category').validate({
    rules: {
      descripcion: {
        required: true,
        maxlength: 250
      },
      nombre: {
        required: true,
        maxlength: 45
      },
    },
    messages: {
      descripcion: {
        required: "Por favor ingrese la descripción",
        maxlength: "La marca no debe superar los 250 caracteres"
      },
      nombre: {
        required: "Por favor ingrese el nombre",
        minlength: "El nombre no debe superar los 45 caracteres"
      },
    },
    errorElement: 'span',
    errorPlacement: function (error, element) {
      error.addClass('invalid-feedback');
      element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass) {
      $(element).addClass('is-invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
      $(element).removeClass('is-invalid');
    }
  });
}

function createClient() {
  $.validator.setDefaults({
    submitHandler: function () {
      swal({
        title: "¡Buen trabajo!",
        text: "¡Creaste una cliente!",
        icon: "success",
        button: "Ver lista",
      }).then(function() {
        window.location = "../../pages/clients/show-clients.html";
      });
    }
  });
  $('#create-client').validate({
    rules: {
      correo: {
        required: true,
        email:true,
        maxlength: 45
      },
      nombre: {
        required: true,
        maxlength: 250
      },
      edad: {
        required: true,
        maxlength: 2
      },
      contrasena: {
        required: true,
        maxlength: 45
      },
    },
    messages: {
      correo: {
        required: "Por favor ingrese el correo",
        maxlength: "La correo no debe superar los 45 caracteres",
        email: "Por favor, digite un correo correcto"
      },
      nombre: {
        required: "Por favor ingrese el nombre",
        minlength: "El nombre no debe superar los 250 caracteres"
      },
      edad: {
        required: "Por favor ingrese la edad",
        maxlength: "La edad no debe superar los 2 caracteres"
      },
      contrasena: {
        required: "Por favor ingrese una contraseña",
        minlength: "la contraseña no debe superar los 45 caracteres"
      },
    },
    errorElement: 'span',
    errorPlacement: function (error, element) {
      error.addClass('invalid-feedback');
      element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass) {
      $(element).addClass('is-invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
      $(element).removeClass('is-invalid');
    }
  });
}

function createMessage() {
  $.validator.setDefaults({
    submitHandler: function () {
      swal({
        title: "¡Buen trabajo!",
        text: "¡Creaste un Mensaje!",
        icon: "success",
        button: "Ver lista",
      }).then(function() {
        window.location = "../../pages/messages/show-messages.html";
      });
    }
  });
  $('#create-message').validate({
    rules: {
      herramienta: {
        required: true,
      },
      textoMensaje: {
        required: true,
        maxlength: 45
      },
    },
    messages: {
      herramienta: {
        required: "Por favor selecciona la herramienta",
      },
      textoMensaje: {
        required: "Por favor ingrese el mensaje",
        minlength: "El mensaje no debe superar los 250 caracteres"
      },
    },
    errorElement: 'span',
    errorPlacement: function (error, element) {
      error.addClass('invalid-feedback');
      element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass) {
      $(element).addClass('is-invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
      $(element).removeClass('is-invalid');
    }
  });
}

function createReserve() {
  $.validator.setDefaults({
    submitHandler: function () {
      swal({
        title: "¡Buen trabajo!",
        text: "¡Creaste una reserva!",
        icon: "success",
        button: "Ver lista",
      }).then(function() {
        window.location = "../../pages/reserves/show-reserves.html";
      });
    }
  });
  $('#create-reserve').validate({
    rules: {
      herramienta: {
        required: true,
      },
      cliente: {
        required: true,
      },
      fechaInicio: {
        required: true,
      },
      fechaTermino: {
        required: true,
      },
    },
    messages: {
      herramienta: {
        required: "Por favor, seleccione la herramienta",
      },
      cliente: {
        required: "Por favor, seleccione el cliente",
      },
      fechaInicio: {
        required: "Por favor, seleccione la fecha de inicio",
      },
      fechaTermino: {
        required: "Por favor, seleccione la fecha de final",
      },
    },
    errorElement: 'span',
    errorPlacement: function (error, element) {
      error.addClass('invalid-feedback');
      element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass) {
      $(element).addClass('is-invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
      $(element).removeClass('is-invalid');
    }
  });
}

function createReserveRating() {
  $.validator.setDefaults({
    submitHandler: function () {
      swal({
        title: "¡Buen trabajo!",
        text: "¡Creaste una calificación de reserva!",
        icon: "success",
        button: "Ver lista",
      }).then(function() {
        window.location = "../../pages/reserve-rating/show-reserve-rating.html";
      });
    }
  });
  $('#create-reserve-rating').validate({
    rules: {
      calificacion: {
        required: true,
        maxlength: 1,
        range:[0,5]
      },
      reserva: {
        required: true,
      },
      mensaje: {
        required: true,
        maxlength: 250
      },
    },
    messages: {
      calificacion: {
        required: "Por favor ingrese la calificación",
        maxlength: "La calificación no debe superar 1 caracter",
        range: "La calificación debe ser entre 0 y 5"
      },
      reserva: {
        required: "Por favor, seleccione la reserva",
      },
      mensaje: {
        required: "Por favor, ingrese el mensaje",
        minlength: "El mensaje no debe superar los 250 caracteres"
      },
    },
    errorElement: 'span',
    errorPlacement: function (error, element) {
      error.addClass('invalid-feedback');
      element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass) {
      $(element).addClass('is-invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
      $(element).removeClass('is-invalid');
    }
  });
}

function createAdminUser() {
  $.validator.setDefaults({
    submitHandler: function () {
      swal({
        title: "¡Buen trabajo!",
        text: "¡Creaste un usuario administrador!",
        icon: "success",
        button: "Ver lista",
      }).then(function() {
        window.location = "../../pages/admin-users/show-admin-users.html";
      });
    }
  });
  $('#create-admin-user').validate({
    rules: {
      correo: {
        required: true,
        email:true,
        maxlength: 45
      },
      nombre: {
        required: true,
        maxlength: 250
      },
      contrasena: {
        required: true,
        maxlength: 45
      },
    },
    messages: {
      correo: {
        required: "Por favor ingrese el correo",
        maxlength: "La correo no debe superar los 45 caracteres",
        email: "Por favor, digite un correo correcto"
      },
      nombre: {
        required: "Por favor ingrese el nombre",
        minlength: "El nombre no debe superar los 250 caracteres"
      },
      contrasena: {
        required: "Por favor ingrese una contraseña",
        minlength: "la contraseña no debe superar los 45 caracteres"
      },
    },
    errorElement: 'span',
    errorPlacement: function (error, element) {
      error.addClass('invalid-feedback');
      element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass) {
      $(element).addClass('is-invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
      $(element).removeClass('is-invalid');
    }
  });
}