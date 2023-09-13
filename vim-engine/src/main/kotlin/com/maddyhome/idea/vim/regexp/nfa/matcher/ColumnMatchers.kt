/*
 * Copyright 2003-2023 The IdeaVim authors
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE.txt file or at
 * https://opensource.org/licenses/MIT.
 */

package com.maddyhome.idea.vim.regexp.nfa.matcher

import com.maddyhome.idea.vim.api.VimCaret
import com.maddyhome.idea.vim.api.VimEditor
import com.maddyhome.idea.vim.regexp.match.VimMatchGroupCollection

internal class AtColumnMatcher(private val columnNumber: Int) : Matcher {
  override fun matches(
    editor: VimEditor,
    index: Int,
    groups: VimMatchGroupCollection,
    isCaseInsensitive: Boolean,
    possibleCursors: MutableList<VimCaret>
  ): MatcherResult {
    return if (editor.offsetToBufferPosition(index).column + 1 == columnNumber) MatcherResult.Success(0)
    else MatcherResult.Failure
  }
}

internal class BeforeColumnMatcher(private val columnNumber: Int) : Matcher {
  override fun matches(
    editor: VimEditor,
    index: Int,
    groups: VimMatchGroupCollection,
    isCaseInsensitive: Boolean,
    possibleCursors: MutableList<VimCaret>
  ): MatcherResult {
    return if (editor.offsetToBufferPosition(index).column + 1 < columnNumber) MatcherResult.Success(0)
    else MatcherResult.Failure
  }
}

internal class AfterColumnMatcher(private val columnNumber: Int) : Matcher {
  override fun matches(
    editor: VimEditor,
    index: Int,
    groups: VimMatchGroupCollection,
    isCaseInsensitive: Boolean,
    possibleCursors: MutableList<VimCaret>
  ): MatcherResult {
    return if (editor.offsetToBufferPosition(index).column + 1 > columnNumber) MatcherResult.Success(0)
    else MatcherResult.Failure
  }
}

internal class AtColumnCursorMatcher : Matcher {
  override fun matches(
    editor: VimEditor,
    index: Int,
    groups: VimMatchGroupCollection,
    isCaseInsensitive: Boolean,
    possibleCursors: MutableList<VimCaret>
  ): MatcherResult {
    return if (editor.offsetToBufferPosition(index).column == editor.offsetToBufferPosition(editor.currentCaret().offset.point).column) MatcherResult.Success(0)
    else MatcherResult.Failure
  }
}

internal class BeforeColumnCursorMatcher : Matcher {
  override fun matches(
    editor: VimEditor,
    index: Int,
    groups: VimMatchGroupCollection,
    isCaseInsensitive: Boolean,
    possibleCursors: MutableList<VimCaret>
  ): MatcherResult {
    return if (editor.offsetToBufferPosition(index).column < editor.offsetToBufferPosition(editor.currentCaret().offset.point).column) MatcherResult.Success(0)
    else MatcherResult.Failure
  }
}

internal class AfterColumnCursorMatcher : Matcher {
  override fun matches(
    editor: VimEditor,
    index: Int,
    groups: VimMatchGroupCollection,
    isCaseInsensitive: Boolean,
    possibleCursors: MutableList<VimCaret>
  ): MatcherResult {
    return if (editor.offsetToBufferPosition(index).column > editor.offsetToBufferPosition(editor.currentCaret().offset.point).column) MatcherResult.Success(0)
    else MatcherResult.Failure
  }
}