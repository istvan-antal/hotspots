HS.API = function () {
    
};

HS.API.prototype.fetchInputs = function () {
    return $.get('/inputs');
};

HS.API.prototype.fetchConsist = function () {
    return $.get('/consist');
};

HS.API.prototype.createInput = function (properties) {
    return $.ajax({
        url: '/inputs',
        type: 'post',
        data: properties
    });
};

HS.API.prototype.removeInput = function (id) {
    return $.ajax({
        url: '/inputs/' + id,
        type: 'delete'
    });
};