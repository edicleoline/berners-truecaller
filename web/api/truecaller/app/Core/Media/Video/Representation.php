<?php

namespace App\Core\Media\Video;

class Representation extends \Streaming\Representation
{
    private $alias;

    public function getAlias(): string
    {
        return $this->alias;
    }

    public function setAlias(string $alias): Representation
    {
        $this->alias = $alias;
        return $this;
    }
}
