/*
 * Copyright (C) 2015 AppTik Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apptik.widget.multiview.animators;


import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView;

public class Providers {
    private Providers() {
        throw new IllegalStateException("no instances");
    }


    public static AnimatorProvider defaultRemoveAnimProvider() {
        return new AnimatorProvider() {
            @Override
            public ViewPropertyAnimatorCompat getAnim(RecyclerView.ViewHolder viewHolder, Object... ags) {
                return Anims.defaultRemoveAnim(viewHolder.itemView);
            }

            @Override
            public Runnable getBeforeAction(RecyclerView.ViewHolder viewHolder, Object... args) {
                return null;
            }

            @Override
            public Runnable getAfterAction(RecyclerView.ViewHolder viewHolder, Object... args) {
                return null;
            }
        };
    }

    public static AnimatorProvider defaultAddAnimProvider() {
        return new AnimatorProvider() {
            @Override
            public ViewPropertyAnimatorCompat getAnim(RecyclerView.ViewHolder viewHolder, Object... ags) {
                return Anims.defaultAddAnim(viewHolder.itemView);
            }

            @Override
            public Runnable getBeforeAction(RecyclerView.ViewHolder viewHolder, Object... args) {
                return null;
            }

            @Override
            public Runnable getAfterAction(RecyclerView.ViewHolder viewHolder, Object... args) {
                return null;
            }
        };
    }

    public static AnimatorProvider defaultMoveAnimProvider() {
        return new AnimatorProvider() {
            @Override
            public ViewPropertyAnimatorCompat getAnim(final RecyclerView.ViewHolder viewHolder, Object... args) {
                return Anims.defaultMoveAnim(viewHolder.itemView);
            }

            @Override
            public Runnable getBeforeAction(final RecyclerView.ViewHolder viewHolder, Object... args) {
                BaseItemAnimator.MoveInfo moveInfo = (BaseItemAnimator.MoveInfo) args[0];
                final int deltaX = moveInfo.toX - moveInfo.fromX;
                final int deltaY = moveInfo.toY - moveInfo.fromY;
                return new Runnable() {
                    @Override
                    public void run() {
                        ViewCompat.setTranslationX(viewHolder.itemView, -deltaX);
                        ViewCompat.setTranslationY(viewHolder.itemView, -deltaY);
                    }
                };
            }

            @Override
            public Runnable getAfterAction(RecyclerView.ViewHolder viewHolder, Object... args) {
                return null;
            }
        };
    }

    public static AnimatorProvider defaultChangeOldViewAnimProvider() {
        return new AnimatorProvider() {
            @Override
            public ViewPropertyAnimatorCompat getAnim(RecyclerView.ViewHolder viewHolder, Object... ags) {
                return Anims.defaultChangeOldViewAnim(viewHolder.itemView, (BaseItemAnimator.ChangeInfo) ags[0]);
            }

            @Override
            public Runnable getBeforeAction(RecyclerView.ViewHolder viewHolder, Object... args) {
                return null;
            }

            @Override
            public Runnable getAfterAction(RecyclerView.ViewHolder viewHolder, Object... args) {
                return null;
            }
        };
    }

    public static AnimatorProvider defaultChangeNewViewAnimProvider() {
        return new AnimatorProvider() {
            @Override
            public ViewPropertyAnimatorCompat getAnim(RecyclerView.ViewHolder viewHolder, Object... ags) {
                return Anims.defaultChangeNewViewAnim(viewHolder.itemView, (BaseItemAnimator.ChangeInfo) ags[0]);
            }

            @Override
            public Runnable getBeforeAction(RecyclerView.ViewHolder viewHolder, Object... args) {
                return null;
            }

            @Override
            public Runnable getAfterAction(RecyclerView.ViewHolder viewHolder, Object... args) {
                return null;
            }
        };
    }


    public static AnimatorProvider garageDoorAddProvider() {
        return new AnimatorProvider() {
            @Override
            public ViewPropertyAnimatorCompat getAnim(RecyclerView.ViewHolder viewHolder, Object... args) {
                return Anims.garageDoorClose(viewHolder.itemView);
            }

            @Override
            public Runnable getBeforeAction(final RecyclerView.ViewHolder viewHolder, Object... args) {
                return new Runnable() {
                    @Override
                    public void run() {
                        ViewCompat.setAlpha(viewHolder.itemView, 1);
                        ViewCompat.setRotationX(viewHolder.itemView, 90);
                        ViewCompat.setTranslationY(viewHolder.itemView, -(viewHolder.itemView.getMeasuredHeight() / 2));
                        viewHolder.itemView.invalidate();
                    }
                };
            }

            @Override
            public Runnable getAfterAction(RecyclerView.ViewHolder viewHolder, Object... args) {
                return null;
            }
        };
    }

    public static AnimatorProvider garageDoorRemoveProvider() {
        return new AnimatorProvider() {
            @Override
            public ViewPropertyAnimatorCompat getAnim(RecyclerView.ViewHolder viewHolder, Object... args) {
                return Anims.garageDoorOpen(viewHolder.itemView);
            }

            @Override
            public Runnable getBeforeAction(RecyclerView.ViewHolder viewHolder, Object... args) {
                return null;
            }

            @Override
            public Runnable getAfterAction(RecyclerView.ViewHolder viewHolder, Object... args) {
                return null;
            }
        };
    }

}
