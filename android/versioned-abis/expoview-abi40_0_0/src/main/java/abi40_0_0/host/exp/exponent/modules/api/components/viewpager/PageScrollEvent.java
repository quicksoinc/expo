/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package abi40_0_0.host.exp.exponent.modules.api.components.viewpager;

import abi40_0_0.com.facebook.react.bridge.Arguments;
import abi40_0_0.com.facebook.react.bridge.WritableMap;
import abi40_0_0.com.facebook.react.uimanager.events.Event;
import abi40_0_0.com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Event emitted by {@link ReactViewPager} when user scrolls between pages (or when animating
 * between pages).
 *
 * Additional data provided by this event:
 *  - position - index of first page from the left that is currently visible
 *  - offset - value from range [0,1) describing stage between page transitions. Value x means that
 *    (1 - x) fraction of the page at "position" index is visible, and x fraction of the next page
 *    is visible.
 */
/* package */ class PageScrollEvent extends Event<PageScrollEvent> {

  public static final String EVENT_NAME = "topPageScroll";

  private final int mPosition;
  private final float mOffset;

  protected PageScrollEvent(int viewTag, int position, float offset) {
    super(viewTag);
    mPosition = position;

    // folly::toJson default options don't support serialize NaN or Infinite value
    mOffset = (Float.isInfinite(offset) || Float.isNaN(offset))
      ? 0.0f : offset;
  }

  @Override
  public String getEventName() {
    return EVENT_NAME;
  }

  @Override
  public void dispatch(RCTEventEmitter rctEventEmitter) {
    rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  private WritableMap serializeEventData() {
    WritableMap eventData = Arguments.createMap();
    eventData.putInt("position", mPosition);
    eventData.putDouble("offset", mOffset);
    return eventData;
  }
}
