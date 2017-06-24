/*
 * Copyright 2017 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hippo.nimingban.component.paper

import android.view.MenuItem
import com.hippo.nimingban.component.NmbLogic
import com.hippo.nimingban.util.INVALID_ID

/*
 * Created by Hippo on 6/19/2017.
 */

abstract class ToolbarLogic : NmbLogic() {

  var toolbarUi: ToolbarUi? = null
    set(value) {
      field = value
      if (value != null) {
        value.setTitle(title)
        value.setSubtitle(subtitle)
        value.setNavigationIcon(icon)
        value.inflateMenu(menu)
      }
    }

  private var title: CharSequence? = null
  private var subtitle: CharSequence? = null
  private var icon: Int = INVALID_ID
  private var menu: Int = INVALID_ID

  fun setTitle(title: CharSequence?) {
    this.title = title
    toolbarUi?.setTitle(title)
  }

  fun setSubtitle(subtitle: CharSequence?) {
    this.subtitle = subtitle
    toolbarUi?.setSubtitle(subtitle)
  }

  fun setNavigationIcon(icon: Int) {
    this.icon = icon
    toolbarUi?.setNavigationIcon(icon)
  }

  fun inflateMenu(menu: Int) {
    this.menu = menu
    toolbarUi?.inflateMenu(menu)
  }

  abstract fun onClickNavigationIcon()

  abstract fun onClickMenuItem(item: MenuItem): Boolean
}