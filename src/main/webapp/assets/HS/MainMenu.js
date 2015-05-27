HS.MainMenu = function (rootView) {
    var self = this;
    
    this._rootView = rootView;

    rootView.on('click', '.item', function () {
        var currentItem = $(this);
        var items = rootView.find('.item');

        items.removeClass('active');
        currentItem.addClass('active');

        var target = currentItem.attr('href').split('#')[1];
        self._onSelectHandlers.forEach(function (fn) {
            fn(target);
        });
    });

    this._onSelectHandlers = [];
};

HS.MainMenu.prototype.onSelect = function (fn) {
    this._onSelectHandlers.push(fn);
};

HS.MainMenu.prototype.select = function (target) {
    var items = this._rootView.find('.item'),
        currentItem = items.filter(function () {
            return $(this).attr('href').split('#')[1] === target;
        });

    items.removeClass('active');
    currentItem.addClass('active');

    this._onSelectHandlers.forEach(function (fn) {
        fn(target);
    });
};