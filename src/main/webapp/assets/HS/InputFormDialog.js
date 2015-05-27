HS.InputFormDialog = function (rootView) {
    this._rootView = rootView;
    var self = this,
        form = this._rootView.find('form');
    
    this._onConfirmHandlers = [];
    
    this._rootView.find('.primary.button').click(function () {
        var valueList = form.serializeArray(),
            values = {};
        
        valueList.forEach(function (value) {
            values[value.name] = value.value;
        });
        
        self._onConfirmHandlers.forEach(function (fn) {
            fn(values);
        });
    });
};

HS.InputFormDialog.prototype.open = function () {
    this._rootView.modal('show');
};

HS.InputFormDialog.prototype.onConfirm = function (fn) {
    this._onConfirmHandlers.push(fn);
};