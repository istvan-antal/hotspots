HS.NetworkConsistModel = function (api) {
    this._api = api;
    this._onInputAdditionHandlers = [];
    this._onConsistUpdateHandlers = [];
    this._onConsistErrorHandlers = [];
    this._initialDataLoaded = false;
};

HS.NetworkConsistModel.prototype.createInput = function (values) {
    var self = this,
        handlers = this._onInputAdditionHandlers;

    this._api.createInput(values).then(function (input) {
        handlers.forEach(function (fn) {
            fn(input);
        });
        
        self._updateConsist();
    });
};

HS.NetworkConsistModel.prototype.removeInput = function (id) {
    var self = this;

    this._api.removeInput(id).then(function () {
        self._updateConsist();
    });
};

HS.NetworkConsistModel.prototype.loadInitialData = function () {
    if (this._initialDataLoaded) {
        throw new Error('Initial data was already loaded');
    }
    
    var handlers = this._onInputAdditionHandlers;
    
    this._api.fetchInputs().then(function (inputs) {
        inputs.forEach(function (input) {
            handlers.forEach(function (fn) {
                fn(input);
            });
        });
    });
    
    this._updateConsist();
};

HS.NetworkConsistModel.prototype._updateConsist = function () {
    var successHandlers = this._onConsistUpdateHandlers,
        errorHandlers = this._onConsistErrorHandlers;

    this._api.fetchConsist().then(function (data) {
        successHandlers.forEach(function (fn) {
            fn(data);
        });
    }, function () {
        errorHandlers.forEach(function (fn) {
            fn();
        });
    });
};

HS.NetworkConsistModel.prototype.onInputAddition = function (fn) {
    this._onInputAdditionHandlers.push(fn);
};

HS.NetworkConsistModel.prototype.onConsistUpdate = function (fn) {
    this._onConsistUpdateHandlers.push(fn);
};

HS.NetworkConsistModel.prototype.onConsistError = function (fn) {
    this._onConsistErrorHandlers.push(fn);
};