HS.MainContentSwitcher = function (rootView) {
    var self = this;
    
    this._rootView = rootView;
    this._contents = rootView.find('.ux-content');
    this._contentMap = {};
    this._contents.each(function () {
        var item = $(this);
        self._contentMap[item.attr('id')] = item;
    });
};

HS.MainContentSwitcher.prototype.select = function (target) {
    this._contents.removeClass('active');
    this._contentMap[target].addClass('active');
};