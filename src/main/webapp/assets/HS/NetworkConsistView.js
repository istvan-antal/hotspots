HS.NetworkConsistView = function (rootView) {
    this._rootView = rootView;
};

HS.NetworkConsistView.prototype.setData = function (data) {
    this._rootView.html(
        data.carriages.map(HS.NetworkConsistView._toCarriageHtml).join('')
    );
};

HS.NetworkConsistView.prototype.setInvalid = function () {
    this._rootView.html('<div class="ui red inverted segment">Invalid network consist</div>');
};

HS.NetworkConsistView._toCarriageHtml = function (carriage) {
    var html = '<div class="ui left floated segment ux-carriage">';
    
    html += '<div class="ui black top attached label"><i class="train icon"></i> ' +
                carriage.id +
            '</div>';
    
    html += carriage.accessPoints.map(HS.NetworkConsistView._toAccessPointHtml).join('');
    
    html += '</div>';
    return html;
};

HS.NetworkConsistView._toAccessPointHtml = function (accessPoint) {
    var html = '<div data-id="' + accessPoint.id + '" data-pair-id="' + accessPoint.meshPairId + '" class="ui ';
    
    if (accessPoint.meshPairId) {
        html += 'green';
    } else {
        html += 'blue';
    }
    
    html += ' label ux-access-point">';
    
    html += ' <i class="wifi icon"></i> ';
    html += accessPoint.id;
    
    html += '</div>';
    
    return html;
};