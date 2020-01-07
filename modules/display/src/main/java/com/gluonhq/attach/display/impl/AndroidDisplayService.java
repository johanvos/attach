/*
 * Copyright (c) 2016, 2019 Gluon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL GLUON BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gluonhq.attach.display.impl;

import com.gluonhq.attach.display.DisplayService;
import com.gluonhq.attach.lifecycle.LifecycleEvent;
import com.gluonhq.attach.lifecycle.LifecycleService;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;

import javafx.stage.Screen;

public class AndroidDisplayService implements DisplayService {


    private static final Logger LOG = Logger.getLogger(AndroidDisplayService.class.getName());

    private final static double MIN_TABLET_DIAGONAL = 6.5;
    
    public AndroidDisplayService() {
    }

    @Override
    public boolean isPhone() {
        return true;
    }

    @Override
    public boolean isTablet() {
        return false;
    }

    @Override
    public boolean isDesktop() {
        return false;
    }

    @Override public Dimension2D getScreenResolution() {
        Rectangle2D bounds = Screen.getPrimary().getBounds();
        return new Dimension2D(bounds.getWidth(), bounds.getHeight());
    }

    @Override
    public Dimension2D getDefaultDimensions() {
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        return new Dimension2D(visualBounds.getWidth(), visualBounds.getHeight());
    }

    @Override
    public float getScreenScale() {
        float screenScale = (float)(Screen.getPrimary().getOutputScaleX());
        return screenScale;
    }

    @Override
    public boolean isScreenRound() {
        return false;
    }

    @Override
    public boolean hasNotch() {
        return false;
    }

    @Override
    public ReadOnlyObjectProperty<Notch> notchProperty() {
        return new ReadOnlyObjectWrapper<>(Notch.UNKNOWN).getReadOnlyProperty();
    }

}
